package perf

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

private val counter = AtomicInteger()

fun main(args: Array<String>) {

    val start = System.currentTimeMillis()

    for (i in 1..100000)
        thread(start = true) {
            counter.addAndGet(i)
        }

    println("Counter ${counter.get()}")

    val millis = (System.currentTimeMillis() - start) / 1000.0
    println("Took $millis millis")

}

