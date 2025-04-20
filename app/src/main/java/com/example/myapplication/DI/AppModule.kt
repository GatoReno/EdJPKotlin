package com.example.myapplication.DI

import com.example.myapplication.Data.GameApi
import com.example.myapplication.Util.Constants.Companion.BaseURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetroFit(): Retrofit{
        return  Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApiGames(retrofit: Retrofit) : GameApi{
        return  retrofit.create(GameApi::class.java)
    }
}