package builders.lazysequence

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.buildSequence


fun main(args: Array<String>) = runBlocking {
    println("Start")

    launch(coroutineContext) {
        for (i in fibonacci.take(15)) {
            println("next: $i")
        }
    }

    println("End")
}

/**
 * The strength of generators is in supporting arbitrary control flow, such as while.
 */
val fibonacci: Sequence<Long> = buildSequence {
    yield(1L) // first Fibonacci number
    var cur: Long = 1
    var next: Long = 1
    while (true) {
        yield(next) // next Fibonacci number
        val tmp = cur + next
        cur = next
        next = tmp
    }
}

