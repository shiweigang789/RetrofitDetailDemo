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
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by swg on 2017/9/1.
 */

public class Example07 {

    public interface BlogService {
        @POST("blog")
        Call<Result<Blog>> createBlog(@Body Blog blog);
    }


    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Blog blog = new Blog();
        blog.setContent("新建的Blog");
        blog.setTitle("测试");
        blog.setAuthor("怪盗swg");

        retrofit.create(BlogService.class).createBlog(blog)
                .enqueue(new Callback<Result<Blog>>() {
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
