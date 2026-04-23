package com.example.test22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class AddPlaceActivity : AppCompatActivity() {

    lateinit var nameInput: EditText
    lateinit var ratingInput: EditText
    lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addplaceactivity)

        nameInput = findViewById(R.id.nameInput)
        ratingInput = findViewById(R.id.ratingInput)
        btnSave = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {

            val name = nameInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull() ?: 0

            val resultIntent = Intent()
            resultIntent.putExtra("name", name)
            resultIntent.putExtra("rating", rating)

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}