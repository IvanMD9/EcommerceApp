package com.example.ecommerceconcept.di

import com.example.ecommerceconcept.data.remote.EcommerceApi
import com.example.ecommerceconcept.data.repository.EcommerceRepositoryImpl
import com.example.ecommerceconcept.domain.repository.EcommerceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEcommerceApi() : EcommerceApi {
        return Retrofit.Builder()
            .baseUrl(EcommerceApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EcommerceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEcommerceRepository(api: EcommerceApi) : EcommerceRepository {
        return EcommerceRepositoryImpl(api)
    }
}