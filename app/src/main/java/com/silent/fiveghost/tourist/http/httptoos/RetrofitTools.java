package com.silent.fiveghost.tourist.http.httptoos;

import com.google.gson.Gson;
import com.silent.fiveghost.tourist.config.Concat;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 农民伯伯
 * @version 2017/12/21
 *          Retrift的单例类
 */

public class RetrofitTools {
    private static RetrofitTools tools;
    private Retrofit retrofit;

    private RetrofitTools() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(Concat.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitTools getInstance() {
        if (tools == null) {
            synchronized (RetrofitTools.class) {
                if (tools == null) {
                    tools = new RetrofitTools();
                }

            }
        }

        return tools;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }


}
