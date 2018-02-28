package advanced.channel

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    println("Start")

    val channel = Channel<Int>()
    launch(coroutineContext) {
        repeat(10, {
            delay(1000)
            channel.send(it)
        })
        channel.close()
    }

    launch(coroutineContext) {
        for (i in channel) {
            println("next: $i")
        }
    }

    println("End")
}

