package com.example.sharedpreferencesinkotlin

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferencesinkotlin.databinding.ActivityViewsBinding

class ViewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("my_db", MODE_PRIVATE)

        sharedPreferences.edit().remove("cgpa").apply()


        binding.name.text = sharedPreferences.getString("name", "Bilash")
        binding.age.text = sharedPreferences.getInt("age", 26).toString()
        binding.cgpa.text = sharedPreferences.getFloat("cgpa", 3.27F).toString()
        binding.ismale.text = sharedPreferences.getBoolean("isMale", false).toString()

    }
}