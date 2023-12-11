package al.misn.trucklogistics.DI

import al.misn.trucklogistics.repository.Api.Api
import al.misn.trucklogistics.repository.Api.ApiImpl
import al.misn.trucklogistics.repository.Local.Local.AppDatabase
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManagerImpl
import al.misn.trucklogistics.repository.Repository
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // or ApplicationComponent if needed
class AppModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedPreferencesManager(sharedPreferences: SharedPreferences): SharedPreferencesManager {
        return SharedPreferencesManagerImpl(sharedPreferences)
    }

    @Provides
    fun provideMyRepository(api: Api, local: AppDatabase): Repository {
        return Repository(api, local)
    }
    @Provides
    fun provideApi(): Api {
        return ApiImpl() // or another implementation if you have one
    }

    @Provides
    fun provideAppDatabase(context: Context, manager: SharedPreferencesManager): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            manager.getUsername() // Assuming getName returns the database name
        ).build()
    }

}