package com.sampleapp.api;

import com.sampleapp.constants.ApiConstants;
import com.sampleapp.model.response.LoginResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Contains API methods to be consumed using Retrofit
 */
public interface RestService {

    //LOGIN API
    @FormUrlEncoded
    @POST(ApiConstants.LOGIN)
    Observable<LoginResponse> login(@Field("email") String email, @Field("password") String password);
}
