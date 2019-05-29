package exception

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doStuff()
}

suspend fun doStuff() = coroutineScope {
    try {
        launch {
            delay(2000)
            throwException()
            println("1 done")
        }
    } catch (ignored: java.lang.RuntimeException) {
    }

    launch {
        delay(4000)
        println("2 done")
    }
}

fun throwException() {
    throw RuntimeException("cats!")
}