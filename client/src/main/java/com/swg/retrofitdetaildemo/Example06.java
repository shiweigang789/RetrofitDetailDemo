package com.swg.retrofitdetaildemo;


import com.google.gson.Gson;
import com.swg.retrofitdetaildemo.entity.Blog;
import com.swg.retrofitdetaildemo.entity.Result;

import retrofit2.Call;
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
        Gson gson = new Gson();
    }



}
