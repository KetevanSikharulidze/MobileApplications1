package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            bookNameTextview.text = intent.extras?.getString("NAME", "no name")
            bookPageTextView.text = intent.extras?.getInt("NUMBER",0).toString()
            bookPriceTextView.text = intent.extras?.getDouble("PRICE", 0.0).toString()
            bookInStoreTextView.text = intent.extras?.getBoolean("INSTORE", false).toString()

            val imageURL = intent.extras?.getString("URL","https://img.freepik.com/premium-psd/book-hardcover-mockup-three-views_125540-226.jpg")
            Glide.with(this@SearchActivity).load(imageURL).into(bookImageView)

        }
    }
}