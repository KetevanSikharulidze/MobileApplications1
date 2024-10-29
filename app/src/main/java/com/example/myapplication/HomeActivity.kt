package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {

    lateinit var bookName: EditText
    lateinit var bookPrice: EditText
    lateinit var bookPageNumber: EditText
    lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bookName = findViewById(R.id.bookNameEditText)
        bookPrice = findViewById(R.id.bookPriceEditText)
        bookPageNumber = findViewById(R.id.pageNumberEditText)
        nextBtn = findViewById(R.id.nextBtn)

        nextBtn.setOnClickListener {
            var name = bookName.text.toString()
            var price = bookPrice.text.toString().toDouble()
            var number = bookPageNumber.text.toString().toInt()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("PRICE",price)
            intent.putExtra("NUMBER",number)
            startActivity(intent)
            finish()
        }



    }
}