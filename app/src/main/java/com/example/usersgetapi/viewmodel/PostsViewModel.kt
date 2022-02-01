package com.example.usersgetapi.viewmodel

import androidx.lifecycle.*
import com.example.usersgetapi.model.network.models.Post
import com.example.usersgetapi.model.repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class PostsViewModel(
    private val postsRepository: PostRepository
): ViewModel() {

    private var _posts: MutableLiveData<List<Post>?> = MutableLiveData()
    val posts: LiveData<List<Post>?> = _posts

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            _posts.postValue(response)
        }
    }

    class Factory(
        private val postsRepository: PostRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
                return PostsViewModel(postsRepository) as T
            } else {
                throw RuntimeException("Could not create instance of PostsViewModel")
            }
        }

    }

}