package br.com.igorbag.githubsearch.data

import br.com.igorbag.githubsearch.domain.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubInterface {

    @GET("users/{user}/repos")
    fun getAllRepositoriesByUserName(@Path("user") user: String): Call<List<Repository>>

}
