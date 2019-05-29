package com.example.coroutines

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersService {
    @GET("{number}")
    fun numberFact(@Path("number") user: Int): Call<String>

    @GET("{number}")
    suspend fun suspendingNumberFact(@Path("number") user: Int): String
}