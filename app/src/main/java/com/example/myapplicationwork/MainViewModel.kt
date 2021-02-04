package com.example.myapplicationwork

import android.content.Context
import androidx.lifecycle.*
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.util.ResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val resProvider: ResProvider,
    private val applicationContext: Context
) : ViewModel() {
    private val _lifeData = MutableLiveData<MutableList<Movie>>()
    val liveData: LiveData<MutableList<Movie>>
        get() = _lifeData

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val moviesDb = MoviesEntityRepository(applicationContext)
            val moviesFromDb = moviesDb.getMovies()

            _lifeData.postValue(moviesFromDb as MutableList<Movie>?)

            val moviesApi = resProvider.loadFilms().toMutableList()
            _lifeData.postValue(moviesApi)

           moviesDb.saveMovies(moviesApi)
        }
    }
}

class MainViewModelFactory(private val resProvider: ResProvider, private val applicationContext: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(resProvider,applicationContext) as T
    }

}