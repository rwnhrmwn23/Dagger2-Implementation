package com.onedev.dicoding.dagger2implementation.di

import com.onedev.dicoding.dagger2implementation.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetroService {
    @GET("repositories")
    fun getDataFromApi(
        @Query("q") query: String
    ): Call<RecyclerList>
}