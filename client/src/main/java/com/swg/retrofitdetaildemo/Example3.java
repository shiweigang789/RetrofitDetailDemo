package com.swg.retrofitdetaildemo;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by swg on 2017/8/31.
 */

public class Example3 {

    public interface BlogService{

        @POST("form")
        @FormUrlEncoded
        Call<ResponseBody> testFormUrlEncoded1(@Field("username") String username, @Field("age") int age);

        @POST("form")
        @FormUrlEncoded
        Call<ResponseBody> testFormUrlEncoded2(@FieldMap Map<String, Object> map);

        @POST("form")
        @Multipart
        Call<ResponseBody> testFileUpload1(@Part("name") RequestBody name, @Part("age") RequestBody age, @Part MultipartBody.Part file);

        @POST("form")
        @Multipart
        Call<ResponseBody> testFileUpload2(@PartMap Map<String, RequestBody> args, @Part MultipartBody.Part flie);

        @POST("form")
        @Multipart
        Call<ResponseBody> testFileUpload3(@PartMap Map<String, RequestBody> args);

    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/localhost:4567/")
                .build();
        BlogService service = retrofit.create(BlogService.class);
        Call<ResponseBody> call = service.testFormUrlEncoded1("swg", 27);
        ResponseBodyPrinter.printResponseBody(call);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "swg1");
        map.put("age", 24);
        Call<ResponseBody> call1 = service.testFormUrlEncoded2(map);
        ResponseBodyPrinter.printResponseBody(call1);

        MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, "swg");
        RequestBody age = RequestBody.create(textType, "24");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "这里是模拟文件的内容");

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        Call<ResponseBody> call2 = service.testFileUpload1(name, age, filePart);
        ResponseBodyPrinter.printResponseBody(call2);

        Map<String, RequestBody> fileUpload2Args = new HashMap<>();
        fileUpload2Args.put("name", name);
        fileUpload2Args.put("age", age);

        Call<ResponseBody> call4 = service.testFileUpload2(fileUpload2Args, filePart); //单独处理文件
        ResponseBodyPrinter.printResponseBody(call4);

        Map<String, RequestBody> fileUpload3Args = new HashMap<>();
        fileUpload3Args.put("name",name);
        fileUpload3Args.put("age",age);
        fileUpload3Args.put("file\"; filename=\"test.txt",file);
        Call<ResponseBody> testFileUpload3 = service.testFileUpload3(fileUpload3Args);
        ResponseBodyPrinter.printResponseBody(testFileUpload3);

    }





}
