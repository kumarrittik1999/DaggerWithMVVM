package com.kumarrittik99.daggerwithmvvm.di.modules

import com.kumarrittik99.daggerwithmvvm.data.remote.FakerAPI
import com.kumarrittik99.daggerwithmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerApiInstance(retrofit: Retrofit): FakerAPI {
        return retrofit.create(FakerAPI::class.java)
    }
}