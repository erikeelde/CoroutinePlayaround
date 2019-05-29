package trivialExample

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        caller()
    }
}

suspend fun caller() = coroutineScope() {
    launch {
        ioCoroutine()
        unconfinedCoroutine()
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

suspend fun calculatePi(): Unit = delay(3000)
suspend fun networkRequest(): Unit = delay(3000)