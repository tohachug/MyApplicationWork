package com.example.myapplicationwork

import androidx.lifecycle.*
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.entity.MovieEntity
import com.example.myapplicationwork.util.ResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val resProvider: ResProvider
) : ViewModel() {
    private val _liveData = MutableLiveData<List<Movie>>()
    val liveData: LiveData<List<Movie>>
        get() = _liveData

    private val db = DataBase.create(PersistencyApp.getContext())
    val movieDao = db.moviesDao
    val entityRepository = MoviesEntityRepository()

    val movieLiveData = movieDao.getAllLiveData()

    private val observer = Observer<List<MovieEntity>> { movieEntityList ->
        viewModelScope.launch {
            val movies = entityRepository.parseToMovieList(movieEntityList)
            _liveData.postValue(movies)
        }
    }

    init {
        movieLiveData.observeForever(observer)
        viewModelScope.launch(Dispatchers.IO) {
        val moviesApi = resProvider.loadFilms()
        entityRepository.saveMovies(moviesApi)
        }
    }

    override fun onCleared() {
        super.onCleared()
        movieLiveData.removeObserver(observer)
    }
}

class MainViewModelFactory(private val resProvider: ResProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(resProvider) as T
    }

}