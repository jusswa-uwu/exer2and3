package com.example.test22

import android.content.Context

class Transposer(val context: Context) {

    val notes = listOf("C","C#","D","D#","E","F","F#", "G", "G#", "A", "A#", "B")
    val reverse_interval = mapOf("D#" to "Eb", "F#" to "Gb","A#" to "Bb")
    val major_interval = listOf(0,2,4,5,7,9)

    fun ChordTransposer(key: List<String>): List<String> {
        if (key.isEmpty()) {
            return emptyList()
        }
        val root = key[0]
        val current_key = matchRoot(root, notes)
        val rotated_notes = rotateKey(current_key, notes)

        return arrangedKey(rotated_notes, major_interval)

    }

    fun arrangedKey(key:List<String>, interval:List<Int>): List<String>
    {
        var res = listOf<String>()
        for(i in 0 until key.size)
        {
            res = res + interval[i].toString()

        }
        return res
    }

    fun rotateKey(root:String,key:List<String>) : List<String>
    {
        val index = key.indexOf(root)
        if (index == -1) return key
        return key.drop(index) + key.take(index)
    }

    fun matchRoot(root: String, key:List<String>): String
    {
        var res = ""
        for(element in key)
        {
            val current_root = element
            if (root == current_root)
            {
                res = current_root
            }
        }
        return res
    }

}
