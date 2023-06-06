package com.example.hotelbookingapp.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CalendarView
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivitySearchBinding
import java.util.*

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dropDown()

    }

    fun selectDate() {
        val year = Calendar.YEAR
        val month = Calendar.MONTH
        val day = Calendar.DAY_OF_MONTH

        binding.setCheckinDate.setOnClickListener() {


        }
    }

    fun dropDown() {
        val sortList = resources.getStringArray(R.array.sortBy)

        val arrayAdapter = ArrayAdapter(this@SearchActivity, R.layout.dropdown_items, sortList)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }
}