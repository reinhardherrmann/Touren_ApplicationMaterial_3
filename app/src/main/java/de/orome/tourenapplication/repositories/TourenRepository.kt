package de.orome.tourenapplication.repositories

import de.orome.tourenapplication.data.daos.TourenDao
import de.orome.tourenapplication.domain.model.Tour
import javax.inject.Inject

class TourenRepository @Inject constructor(
    private val tourenDao: TourenDao
) {

    suspend fun insertNewTour(tour: Tour) = tourenDao.insertTour(tour)

}