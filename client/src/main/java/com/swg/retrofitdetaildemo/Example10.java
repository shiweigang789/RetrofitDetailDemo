package com.swg.retrofitdetaildemo;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by swg on 2017/9/1.
 */

public class Example10 {

    public interface BlogService {
        @GET("blog/{id}")
        CustomCall<String> getBlog(@Path("id") int id);
    }

    public static class CustomCall<R> {
        public final Call<R> mCall;
        public CustomCall(Call<R> call){
            this.mCall = call;
        }

        public R get() throws IOException {
            return mCall.execute().body();
        }

    }

    public static class CustomCallAdapter implements CallAdapter<CustomCall<?>>{

        private final Type responseType;

        public CustomCallAdapter (Type responseType){
            this.responseType = responseType;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @Override
        public <R> CustomCall<?> adapt(Call<R> call) {
            return new CustomCall<>(call);
        }
    }

    public static class CustomCallAdapterFactory extends CallAdapter.Factory {

        public static final CustomCallAdapterFactory INSTANCE = new CustomCallAdapterFactory();

        public static CustomCallAdapterFactory create() {
            return INSTANCE;
        }

        @Override
        public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            Class<?> rawType = getRawType(returnType);
            if (rawType == CustomCall.class && returnType instanceof ParameterizedType){
                Type callReturnType = getParameterUpperBound(0, (ParameterizedType) returnType);
                return new CustomCallAdapter(callReturnType);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .addConverterFactory(Example09.StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CustomCallAdapterFactory.create())
                .build();

        CustomCall<String> call = retrofit.create(BlogService.class)
                .getBlog(2);
        try {
            String result = call.get();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
