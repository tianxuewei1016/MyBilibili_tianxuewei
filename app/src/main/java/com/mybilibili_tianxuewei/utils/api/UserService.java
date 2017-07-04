package com.mybilibili_tianxuewei.utils.api;

import com.mybilibili_tianxuewei.bean.RecommendBean;

import retrofit2.http.GET;
import rx.Observable;

import static com.mybilibili_tianxuewei.utils.ApiConstants.Recommend_URL;

/**
 * 作者：田学伟 on 2017/7/4 18:50
 * QQ：93226539
 * 作用：
 */

public interface UserService {
    @GET(Recommend_URL)
    Observable<RecommendBean> getRecommendURLInfo();

}
