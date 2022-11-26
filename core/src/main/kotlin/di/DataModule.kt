package di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.datasource.api.RetrofitApi
import data.datasource.api.ServiceApi
import data.datasource.database.DatabaseDataSourceImpl
import data.datasource.database.LocalDatabase
import data.repository.RepositoryImpl
import domain.dataSource.DatabaseDataSource
import domain.repository.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRepository(database: DatabaseDataSource): Repository = RepositoryImpl(database)

    @Provides
    @Singleton
    fun provideDatabaseDataSource(localDatabase: LocalDatabase): DatabaseDataSource =
        DatabaseDataSourceImpl(localDatabase)

    @Provides
    @Singleton
    fun provideLocalDatabase(app: Application): LocalDatabase = LocalDatabase.getInstance(app)

    @Provides
    @Singleton
    fun provideApi(): ServiceApi = RetrofitApi.retrofitService
}