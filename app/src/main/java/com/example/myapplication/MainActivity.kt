package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            val name = intent.extras?.getString("NAME", "no name")
            val number = intent.extras?.getInt("NUMBER",0)
            val price = intent.extras?.getDouble("PRICE", 0.0)

            okBtn.setOnClickListener{
                if (inStoreCheckBox.isChecked){

                    val imageURL = imageUrlEditText.text.toString()

                    val intent = Intent(this@MainActivity,SearchActivity::class.java)
                    intent.putExtra("INSTORE",true)
                    intent.putExtra("NAME", name)
                    intent.putExtra("NUMBER", number)
                    intent.putExtra("PRICE", price)
                    intent.putExtra("URL",imageURL) // image url გადაეწოდება აქიდან
                    startActivity(intent)
//                    finish() სტეკიდან ამოაგდებს ამ კონკრეტულ ექთივითის
                } else {
                    //toast
                    Toast.makeText(this@MainActivity, "not checked!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


            }
        }

    }
}