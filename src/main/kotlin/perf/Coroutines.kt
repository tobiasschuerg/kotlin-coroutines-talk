package perf

import kotlinx.coroutines.experimental.launch
import java.util.concurrent.atomic.AtomicInteger

private val counter = AtomicInteger()

fun main(args: Array<String>) {

    val start = System.currentTimeMillis()

    for (i in 1..100000) {
        launch {
            counter.addAndGet(i)
        }
    }

    println("Counter ${counter.get()}")

    val millis = (System.currentTimeMillis() - start) / 1000.0
    println("Took $millis millis")

}

