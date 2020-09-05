package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository

import androidx.lifecycle.MutableLiveData
import com.uninorte.a_202030_courseinfowithlogin.model.Post
import com.uninorte.a_202030_courseinfowithlogin.repository.api.post.PostsApiService

class PostRepository {
    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    private val apiService = PostsApiService()

    suspend fun getPosts() = apiService.getPosts()

    suspend fun getPost(index : Int) = apiService.getPost(index)

    suspend fun postAPost(post: Post) = apiService.postAPost(post)
}