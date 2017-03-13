package com.example.alex.codalineretrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Call<UsersResponse> users();

}
