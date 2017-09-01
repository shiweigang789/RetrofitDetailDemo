package com.swg.retrofitdetaildemo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swg.retrofitdetaildemo.entity.Blog;
import com.swg.retrofitdetaildemo.entity.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by swg on 2017/9/1.
 */

public class Example06 {

    public interface BlogService {
        @GET("blog/{id}")
        Call<Result<Blog>> getBlog(@Path("id") int id);
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BlogService service = retrofit.create(BlogService.class);
        Call<Result<Blog>> call = service.getBlog(2);
        call.enqueue(new Callback<Result<Blog>>() {
            @Override
            public void onResponse(Call<Result<Blog>> call, Response<Result<Blog>> response) {
                // 已经转换为想要的类型了
                Result<Blog> result = response.body();
                System.out.println(result.toString());
            }

            @Override
            public void onFailure(Call<Result<Blog>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
