package com.example.weathercomposeapp.repository_model.di

import com.example.weathercomposeapp.repository_model.Repository
import com.example.weathercomposeapp.repository_model.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun getRepository(repository: RepositoryImp): Repository
}