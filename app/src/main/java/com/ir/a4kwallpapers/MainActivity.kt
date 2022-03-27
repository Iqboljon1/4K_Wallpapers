package com.ir.a4kwallpapers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.MyShare.MyShare
import com.ir.a4kwallpapers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        setContentView(binding.root)
        MyShare.init(this)
        arrayListWallpapers = ArrayList()
        arrayListWallpapers.addAll(MyShare.dataList!!)
        if (arrayListWallpapers.isEmpty()) {
            arraylistCollection()
        }
    }

    private fun arraylistCollection() {
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__1_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Book",
            "Book",
            R.drawable.image__2_,
            true,
            arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Uzbekistan",
            "Uzbekistan",
            R.drawable.image__3_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Uzbekistan",
            "Uzbekistan",
            R.drawable.image__4_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__5_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Animals",
            "Animals",
            R.drawable.image__6_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Coding",
            "Coding",
            R.drawable.image__7_,
            true, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Nature",
            "Nature",
            R.drawable.image__9_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__10_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Book",
            "Book",
            R.drawable.image__11_,
            false,
            arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Uzbekistan",
            "Uzbekistan",
            R.drawable.image__12_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__13_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Uzbekistan",
            "Uzbekistan",
            R.drawable.image__14_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Uzbekistan",
            "Uzbekistan",
            R.drawable.image__15_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Animals",
            "Animals",
            R.drawable.image__16_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Animals",
            "Animals",
            R.drawable.image__17_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Animals",
            "Animals",
            R.drawable.image__18_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Nature",
            "Nature",
            R.drawable.image__19_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers(
            "Nature",
            "Nature",
            R.drawable.image__22_,
            false, arrayListWallpapers.size,
        ))
        arrayListWallpapers.add(DataClassWallpapers("Book",
            "Book",
            R.drawable.image__23_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Book",
            "Book",
            R.drawable.image__24_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Nature",
            "Nature",
            R.drawable.image__25_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Animals",
            "Animals",
            R.drawable.image__26_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Nature",
            "Nature",
            R.drawable.image__27_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Book",
            "Book",
            R.drawable.image__28_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__29_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Coding",
            "Coding",
            R.drawable.image__30_,
            false, arrayListWallpapers.size))
        arrayListWallpapers.add(DataClassWallpapers("Technology",
            "Technology",
            R.drawable.image__31_,
            false, arrayListWallpapers.size))
        MyShare.dataList = arrayListWallpapers
    }
}