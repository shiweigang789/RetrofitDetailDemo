package com.swg.retrofitdetaildemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swg.retrofitdetaildemo.entity.Blog;
import com.swg.retrofitdetaildemo.entity.Result;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by swg on 2017/9/1.
 */

public class Example08 {

    public interface BlogService {
        @GET("blog")
        Observable<Result<List<Blog>>> getBlogs(@Query("page") int page);
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        retrofit.create(BlogService.class)
                .getBlogs(1)
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Result<List<Blog>>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("onError");
                    }

                    @Override
                    public void onNext(Result<List<Blog>> listResult) {
                        System.out.println(listResult.toString());
                    }
                });

    }

}
