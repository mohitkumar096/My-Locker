package com.mohit.mylocker.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitIntance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

//    private val retrofit = Retrofit
//        .Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    val api: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
    @Provides
    @Singleton
fun provideApiService(retrofit: Retrofit): ApiService{
    return retrofit.create(ApiService::class.java)
}
}