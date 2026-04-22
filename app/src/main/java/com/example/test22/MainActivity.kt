package com.example.test22

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var search: EditText

    lateinit var btnHigh: Button
    lateinit var btnLow: Button

    lateinit var adapter: PlaceAdapter
    lateinit var fullList: ArrayList<Place>

    private var hightToLow = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHigh = findViewById(R.id.btnHighToLow)
        btnLow = findViewById(R.id.btnLowToHigh)

        listView = findViewById(R.id.listView)
        search = findViewById(R.id.search)

        fullList = arrayListOf(
            Place("Cebu IT Park", 3),
            Place("SM Seaside", 4),
            Place("Ayala Center", 5),
            Place("Osmeña Peak", 2),
            Place("Temple of Leah", 4)
        )

        adapter = PlaceAdapter(this, fullList)
        listView.adapter = adapter

        btnHigh.setOnClickListener {
            adapter.sortByRating(highToLow = true)
        }

        btnLow.setOnClickListener {
            adapter.sortByRating(highToLow = false)
        }
        // 🔍 SEARCH FEATURE
        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}