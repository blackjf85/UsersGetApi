package com.example.usersgetapi.viewmodel

import androidx.lifecycle.*
import com.example.usersgetapi.model.network.models.User
import com.example.usersgetapi.model.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class UsersViewModel(
    private val usersRepository: UserRepository
): ViewModel() {

    private var _users: MutableLiveData<List<User>?> = MutableLiveData()
    val users: LiveData<List<User>?> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val response = usersRepository.getUsers()
            _users.postValue(response)
        }
    }

    class Factory(
        private val usersRepository: UserRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
                return UsersViewModel(usersRepository) as T
            } else {
                throw RuntimeException("Could not create instance of UsersViewModel")
            }
        }

    }

}