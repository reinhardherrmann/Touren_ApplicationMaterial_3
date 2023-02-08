package de.orome.tourenapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import de.orome.tourenapplication.data.daos.TourenDao
import de.orome.tourenapplication.domain.model.Tour

@Database(entities = [Tour::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun tourDao(): TourenDao
}