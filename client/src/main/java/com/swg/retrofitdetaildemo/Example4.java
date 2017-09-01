package com.swg.retrofitdetaildemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by swg on 2017/9/1.
 */

public class Example4 {

    public interface BlogService {
        @GET("headers?showAll=true")
        @Headers({"CustomHeader1:customHeaderValue1", "CustomHeader2:customHeaderValue2"})
        Call<ResponseBody> testHeader(@Header("customHeader3") String customHeaderValue3);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build();
        BlogService service = retrofit.create(BlogService.class);
        Call<ResponseBody> call = service.testHeader("swgg");
        ResponseBodyPrinter.printResponseBody(call);

    }


}
