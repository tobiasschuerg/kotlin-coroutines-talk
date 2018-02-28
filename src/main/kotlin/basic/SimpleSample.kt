package basic

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


fun main(args: Array<String>) {
    println("Before")

    launch {
        val result: Int = longRunningComputation()
        println("Result of computation is $result")
    }

    println("After")
    Thread.sleep(2000)
    println("End")
}


suspend fun longRunningComputation(): Int {
    println("-- Start::coroutine")
    delay(1000)
    println("-- End::coroutine")
    return 42
}

