package `2`

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        caller()
    }
}

suspend fun caller() {
    coroutineScope {
        launch {
            ioCoroutine()
        }

        launch {
            unconfinedCoroutine()
        }
    }
}

suspend fun ioCoroutine() = withContext(Dispatchers.IO) {
    networkRequest()
    println("Io thread: ${Thread.currentThread().name}")
}

suspend fun unconfinedCoroutine() = withContext(Dispatchers.Unconfined) {
    calculatePi()
    println("Unconfined thread: ${Thread.currentThread().name}")
}

suspend fun calculatePi(): Unit = delay(5000)
suspend fun networkRequest(): Unit = delay(5000)