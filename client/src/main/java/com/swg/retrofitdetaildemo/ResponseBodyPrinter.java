package com.swg.retrofitdetaildemo;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by swg on 2017/8/31.
 */

public class ResponseBodyPrinter {

    public static void printResponseBody(Call<ResponseBody> call){
        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.err.println("HttpCode:" + response.code());
                System.err.println("Message:" + response.message());
                System.err.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
