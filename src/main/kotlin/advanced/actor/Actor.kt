package advanced.actor

import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    println("Start")

    val printer = actor<Int> {
        for (i in channel) {
            println("next: $i")
        }
    }

    launch(coroutineContext) {
        repeat(10, {
            delay(1000)
            printer.send(it)
        })
        printer.close()
    }

    println("End")
}
