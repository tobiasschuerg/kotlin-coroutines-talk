package other

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubClient {
    @GET("/users/{user}")
    fun user(
            @Path("user") user: String
    ): Call<GitHubUser>

    @GET("/users/{user}/repos")
    fun reposForUser(
            @Path("user") user: String
    ): Call<List<GitHubRepo>>


    @GET("/users/{user}")
    fun userSingle(
            @Path("user") user: String
    ): Single<GitHubUser>

    @GET("/users/{user}/repos")
    fun reposForUserSingle(
            @Path("user") user: String
    ): Single<List<GitHubRepo>>
}


data class GitHubRepo(val id: Int, val name: String)

data class GitHubUser(val id: Int, val login: String)