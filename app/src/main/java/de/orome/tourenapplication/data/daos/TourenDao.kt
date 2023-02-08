package de.orome.tourenapplication.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.orome.tourenapplication.domain.model.Tour
import kotlinx.coroutines.flow.Flow


@Dao
interface TourenDao {
    // TODO: impement needed functions to manipulate the data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTour(tour: Tour)

    @Query("SELECT * FROM tbl_touren ORDER BY tr_tour_datum DESC")
    fun getAllTouren(): Flow<MutableList<Tour>>

}