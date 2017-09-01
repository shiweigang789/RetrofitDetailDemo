package com.swg.retrofitdetaildemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * Created by swg on 2017/8/31.
 */

public class Example2 {

    public interface BlogService{
        @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
        Call<ResponseBody> getBlog(@Path("id") int id);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();
        Call<ResponseBody> call = retrofit.create(BlogService.class)
                .getBlog(3);

       ResponseBodyPrinter.printResponseBody(call);
    }

}
