package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            runBlocking {
                value()
            }
        }
    }

    suspend fun value() {
        delay(2000)
        val number = binding.etEnterNumber?.text.toString().toInt()
        val result = number + 1 + myNumber
        myNumber++
        binding.tvCounter.text = result.toString()

    }


}