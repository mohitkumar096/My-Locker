package com.mohit.mylocker.data.repository
import com.mohit.mylocker.data.remote.ApiService
import com.mohit.mylocker.data.remote.RetrofitIntance
import com.mohit.mylocker.domain.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(private val api: ApiService){

    suspend fun getUser(): List<User> {
        val response = api.getUsers()
        if (response.isSuccessful){
            return  response.body() ?: emptyList()
        } else{
            throw Exception("Api Error")
        }
    }
}