package `3`

import kotlinx.coroutines.*

fun main() {

    getToken { token ->
        getUserInfo(token) { userInfo ->
            getUserProfilePicture(userInfo.profilePictureUrl) { userImage ->
                // consume image
            }
        }
    }

    val job = Job()
    val viewModelScope = CoroutineScope(Dispatchers.Default + job)

    viewModelScope.launch(Dispatchers.Main) {
        val token = getToken()
        val userInfo = getUserInfo(token)
        val userImage = getUserProfilePicture(userInfo.profilePictureUrl)
        // consume image
    }
}

fun coroutineJob() {
    runBlocking {
        val job = launch { delay(100) }
        job.join()
        job.cancel()
    }
}

val job = Job()
val scope = CoroutineScope(Dispatchers.Default + job)

fun doStuff() {
    scope.launch {
        val cpuOperation = cpuOperation()
        updateUi(cpuOperation)
        val networkOperationResult = networkOperation()
        updateUi(networkOperationResult)
    }
}

suspend fun cpuOperation() = withContext(Dispatchers.Default) {
    delay(200)
    return@withContext "networkResult"
}

suspend fun networkOperation() = withContext(Dispatchers.IO) {
    delay(2000)
    return@withContext "networkResult"
}


fun updateUi(cpuOperation: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

suspend fun getUserProfilePicture(profilePictureUrl: String) {

}

fun getUserProfilePicture(profilePictureUrl: String, function: (UserInfo) -> Unit) {

}

data class UserInfo(val profilePictureUrl: String)

suspend fun getUserInfo(token: String): UserInfo {
    delay(100)
    return UserInfo("")
}

fun getUserInfo(result: Callback<Int>, function: (UserInfo) -> Unit) {

}

suspend fun getToken(): String {
    delay(100)
    return ""
}

fun getToken(callback: (Callback<Int>) -> Unit) {

}


interface Callback<E> {
    fun result(result: E)
}