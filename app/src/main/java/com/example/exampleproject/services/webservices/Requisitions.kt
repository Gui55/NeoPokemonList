package com.example.exampleproject.services.webservices

import com.example.exampleproject.services.model.PokePageResult
import retrofit2.Call
import retrofit2.http.GET

interface Requisitions {

    @GET("pokemon")
    fun getPageResult() : Call<PokePageResult>

}