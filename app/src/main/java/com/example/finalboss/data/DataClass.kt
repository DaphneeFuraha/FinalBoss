package com.example.finalboss.data

import com.example.finalboss.R
import com.example.finalboss.model.dreaming

class DataClass(){
    fun hatasijui():List<dreaming>{
        return listOf<dreaming>(
            dreaming(R.string.bones, R.drawable.bones),
            dreaming(R.string.book, R.drawable.book),
            dreaming(R.string.dark, R.drawable.dark),
            dreaming(R.string.dress, R.drawable.dress),
            dreaming(R.string.dune, R.drawable.dune),
            dreaming(R.string.elliot, R.drawable.elliot),
            dreaming(R.string.hallow, R.drawable.hallow),
            dreaming(R.string.images, R.drawable.images),
            dreaming(R.string.life, R.drawable.life),
            dreaming(R.string.nature, R.drawable.nature),
            dreaming(R.string.samar, R.drawable.samar),
            dreaming(R.string.wed, R.drawable.wed),
        )
    }
}
