package basic

import io.reactivex.Observable
import other.GitHubRepo
import other.GitHubUser

// 1. sequential - direct style
fun printUserRepos1(name: String) {
    val user = loadUser(name)
    val repos = listRepos(name)
    repos.forEach { /* do something */ }
}


// 2. callbacks
fun printUserRepos2(name: String) {
    loadUser(name) { user ->
        listRepos(name) { repos ->
            repos.forEach { /* do something */ }
        }
    }
}


// 3. RX
fun printUserRepos3(name: String) {
    loadUser3(name)
            .flatMap { loadRepos(it) }
            .flatMapIterable { it }
            .subscribe({ println("RX: $it") })
}

// 4. Coroutine
suspend fun printUserRepos4(name: String) {
    val user = loadUser(name)
    val repos = listRepos(name)
    repos.forEach { /* do something */ }
}


// TODO
private fun loadUser(name: String): Any = TODO()

private fun listRepos(name: String): List<Any> = TODO()
private fun loadUser(name: String, any: (String) -> Unit): Unit = TODO()
private fun listRepos(name: String, any: (String) -> Unit): Unit = TODO()

private fun loadUser3(name: String): Observable<GitHubUser> = TODO()
private fun loadRepos(it: GitHubUser): Observable<List<GitHubRepo>> = TODO()
