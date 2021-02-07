package com.example.myapplicationwork

import androidx.lifecycle.*
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.util.ResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val resProvider: ResProvider
) : ViewModel() {
    private val _lifeData = MutableLiveData<List<Movie>>()
    val liveData: LiveData<List<Movie>>
        get() = _lifeData

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val moviesDb = MoviesEntityRepository()
            val moviesFromDb = moviesDb.getMovies()

            _lifeData.postValue(moviesFromDb)

            val moviesApi = resProvider.loadFilms()
            _lifeData.postValue(moviesApi)

           moviesDb.saveMovies(moviesApi)
        }
    }
}

class MainViewModelFactory(private val resProvider: ResProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(resProvider) as T
    }

}