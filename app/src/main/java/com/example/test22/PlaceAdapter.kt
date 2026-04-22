package com.example.test22

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class PlaceAdapter(
    val context: Context,
    private var originalList: ArrayList<Place>
) : BaseAdapter() {

    private var filteredList = ArrayList(originalList)

    override fun getCount(): Int = filteredList.size
    override fun getItem(position: Int): Any = filteredList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    fun sortByRating(highToLow: Boolean) {

        filteredList = if (highToLow) {
            ArrayList(filteredList.sortedByDescending { it.rating })
        } else {
            ArrayList(filteredList.sortedBy { it.rating })
        }

        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_place, parent, false)

        val name = view.findViewById<TextView>(R.id.placeName)
        val rating = view.findViewById<TextView>(R.id.placeRating)
        val btnPlus = view.findViewById<Button>(R.id.btnPlus)
        val btnMinus = view.findViewById<Button>(R.id.btnMinus)

        val place = filteredList[position]

        name.text = place.name
        rating.text = "Rating: ${place.rating}"

        btnPlus.setOnClickListener {
            place.rating++
            notifyDataSetChanged()
        }

        btnMinus.setOnClickListener {
            if (place.rating > 0) place.rating--
            notifyDataSetChanged()
        }

        return view
    }

    // 🔍 FILTER FUNCTION
    fun filter(text: String) {
        filteredList = if (text.isEmpty()) {
            ArrayList(originalList)
        } else {
            ArrayList(originalList.filter {
                it.name.lowercase().contains(text.lowercase())
            })
        }
        notifyDataSetChanged()
    }
}