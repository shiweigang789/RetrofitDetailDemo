package com.swg.retrofitdetaildemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by swg on 2017/9/1.
 */

public class Example05 {

    public interface BlogService {
        @GET
        Call<ResponseBody> testUrlAndQuery(@Url String url, @Query("showAll") boolean showAll);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();

        BlogService service = retrofit.create(BlogService.class);
        Call<ResponseBody> call = service.testUrlAndQuery("headers", false);
        ResponseBodyPrinter.printResponseBody(call);
    }


}
