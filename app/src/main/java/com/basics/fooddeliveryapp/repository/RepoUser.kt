package com.kiran.student.repository

import com.basics.fooddeliveryapp.api.MyApiRequest
import com.basics.fooddeliveryapp.entity.User
import com.basics.fooddeliveryapp.rensponse.LoginResponse
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.api.UserAPI

class RepoUser : MyApiRequest() {
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //Login User
    suspend fun loginUser(username: String, password:String): LoginResponse{
        return  apiRequest {
            userAPI.checkUser(username,password)
        }
    }
}