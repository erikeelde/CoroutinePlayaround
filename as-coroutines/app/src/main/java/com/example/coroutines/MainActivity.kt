package com.example.coroutines

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import kotlin.random.Random

private const val TAG: String = "CrtAct"

class MainActivity : AppCompatActivity() {

    var retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("http://numbersapi.com/")
        .build()

    var service = retrofit.create<NumbersService>(NumbersService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val textView = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.button).setOnClickListener {

            runBlocking { delay(2000) }

//            lifecycleScope.launch { delay(2000) }


//            try {
//                val funNumber = getFunNumber()
//                textView.text = "Fetching fact for fun number: $funNumber"
//                val networkResponse: String? = service.numberFact(funNumber).execute().body()
//                findViewById<TextView>(R.id.textView).text = networkResponse
//            } catch(ignored: IOException){}


//            runBlocking {
//                val funNumber = getFunNumber()
//                textView.text = "Fetching fact for fun number: $funNumber"
//                delay(2000)
//                val networkResponses: String = service.suspendingNumberFact(funNumber)
//                textView.text = networkResponses
//            }


//            lifecycleScope.launch {
//                val funNumber = getFunNumber()
//                textView.text = "Fetching fact for fun number: $funNumber"
//                delay(2000)
//                val networkResponses: String = service.suspendingNumberFact(getFunNumber())
//                findViewById<TextView>(R.id.textView).text = networkResponses
//            }
        }
    }


    companion object {
        val random = Random.Default
        fun getFunNumber() = random.nextInt(from = 0, until = 100)
    }
}
