package de.orome.tourenapplication.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.orome.tourenapplication.data.AppDatabase
import de.orome.tourenapplication.domain.model.Tour
import de.orome.tourenapplication.utils.Constants.APP_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,AppDatabase::class.java,APP_DATABASE
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideTourDao(db: AppDatabase) = db.tourDao()

    @Provides
    @Singleton
    fun provideTourEntity() = Tour()

}