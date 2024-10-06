package com.example.sharedpreferencesinkotlin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesinkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("my_db", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.submit.setOnClickListener{
            editor.putString("name", binding.name.text.toString())
            editor.putInt("age", binding.age.text.toString().toInt())
            editor.putFloat("cgpa", binding.cgpa.text.toString().toFloat())
            editor.putBoolean("isMale", binding.isMale.text.toString().toBoolean())
            editor.commit()
        }

        binding.secondActivity.setOnClickListener{
            startActivity(Intent(applicationContext, ViewsActivity::class.java))
        }

    }
}