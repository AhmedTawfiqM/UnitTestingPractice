package com.atdev.unittestingpractice.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atdev.unittestingpractice.R
import com.atdev.unittestingpractice.core.entities.ImageResponse

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoppingViewModel
    private lateinit var tvImages: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        tvImages = findViewById(R.id.tvImages)

        viewModel.images.observe(this, {
            val response = it.peekContent().data
            response?.hits?.size?.let { size ->
                tvImages.text = "got $size images"
            }

        })
    }
}