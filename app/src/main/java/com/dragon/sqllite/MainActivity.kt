package com.dragon.sqllite

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dragon.sqllite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvText.text = pref.getString("curent", "")
        binding.textView.text = pref.getString("description", "")
        binding.button.setOnClickListener {
            val curent = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()
            saveDate(curent, description)
            binding.tvText.text = curent
            binding.textView.text = description
        }





}
    fun saveDate(curent: String, description: String ){
        val edit = pref.edit()
        edit.putString("curent", curent)
        edit.putString("description", description)
        edit.apply()
    }
}