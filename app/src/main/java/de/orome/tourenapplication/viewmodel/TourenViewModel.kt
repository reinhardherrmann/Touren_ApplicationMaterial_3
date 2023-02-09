package de.orome.tourenapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.orome.tourenapplication.domain.model.Tour
import de.orome.tourenapplication.repositories.TourenRepository
import de.orome.tourenapplication.utils.DataStatus
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TourenViewModel @Inject constructor(
    private val tourenRpository: TourenRepository
) : ViewModel() {

    private val _tourenList = MutableLiveData<DataStatus<List<Tour>>>()
    val tourenList: LiveData<DataStatus<List<Tour>>>
        get() = _tourenList

    fun insertTour(tour: Tour) = viewModelScope.launch {
        tourenRpository.insertNewTour(tour)
    }

    fun getAllTouren() = viewModelScope.launch {
        _tourenList.postValue(DataStatus.loading())
        tourenRpository.getAllTouren()
            .catch { _tourenList.postValue(DataStatus.error(it.message.toString())) }
            .collect { _tourenList.postValue(DataStatus.success(it, it.isEmpty())) }
    }


}