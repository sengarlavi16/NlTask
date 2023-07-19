package com.community.nltask.api

import com.community.nltask.api.models.City
import com.community.nltask.api.models.Countries
import com.community.nltask.api.models.Pincode
import com.community.nltask.api.models.States
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    /*Countries Api */
    @GET(ApiConstants.COUNTRIES)
    fun getCountries(): Call<Countries>

    /*States Api */
    @GET(ApiConstants.STATES)
    fun getStates(): Call<States>

    /*City Api */
    @GET(ApiConstants.CITY)
    fun getCity(@Path("state_id") state_id:String?): Call<City>

    /*Pincode Api */
    @GET(ApiConstants.PINCODE)
    fun getPincode(@Path("city_id") city_id:String?): Call<Pincode>
}