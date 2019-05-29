package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flowOf(1, 2, 3, 4, 5)
        .delayEach(500)
        .map { it * it }
        .collect { println(it) } //collects each emitted item and prints to the console


    println("\n*******\n")


    val ints: Flow<Int> = flow {
        for (i in 1..10) {
            delay(100)
            emit(i)
        }
    }

    ints.filter { it % 2 == 0 }
        .map { it * it }
        .collect { println(it) } // takes 1 second, prints 10 ints

}