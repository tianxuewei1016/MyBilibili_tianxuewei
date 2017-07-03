package com.mybilibili_tianxuewei.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：田学伟 on 2017/7/3 20:55
 * QQ：93226539
 * 作用：网络请求的工具类
 */

public class RetrofiUtils {
//    public static UserService getUserAPI() {
//
//        return createApi(UserService.class, ApiConstants.USER_BASE_URL);
//    }

    /**
     * 根据传入的baseUrl，和api创建retrofit
     */
    private static <T> T createApi(final Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .build();

        return retrofit.create(clazz);
    }
}
