package other

import kotlinx.coroutines.experimental.async
import ru.gildor.coroutines.retrofit.await
import kotlin.coroutines.experimental.suspendCoroutine

fun main(args: Array<String>) {
    println("Before")

    // Coroutine
    async {
        val user = Client.client.user("tobiasschuerg").await()

        Client.client.reposForUser(user.login)
                .await()
                .filter { it.name.contains("android") }
                .forEach { println("CR: $it") }
    }


    // RX
    Client.client.userSingle("tobiasschuerg")
            .flatMap { Client.client.reposForUserSingle(it.login) }
            .toObservable()
            .flatMapIterable { it }
            .filter { it.name.contains("android") }
            .subscribe({
                println("RX: $it")
            })


    println("After")
    Thread.sleep(2000)
    println("End")
}


suspend fun callback() = suspendCoroutine<Int> {

    it.resume(1)

    it.resumeWithException(Error("foo"))

}


