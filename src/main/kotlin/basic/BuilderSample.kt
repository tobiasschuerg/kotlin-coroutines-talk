package basic

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    println("Before")

    launch {
        val result: Int = longRunningComputation()
        println("Result of computation is $result")
    }

    println("After")
    Thread.sleep(2000)
    println("End")
}


