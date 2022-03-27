package com.ir.a4kwallpapers.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.gson.Gson
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.ItemFragment

class AdapterViewPager(
    var arrayListTypes: ArrayList<String>,
    private var arrayListWallpapers: ArrayList<DataClassWallpapers>,
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return arrayListTypes.size
    }

    override fun createFragment(position: Int): Fragment {
        var arrayList = ArrayList<DataClassWallpapers>()
        if (position != 0) {
            for (i in arrayListWallpapers) {
                if (i.imageType == arrayListTypes[position]){
                    arrayList.add(i)
                }
            }
            var gsonString = listToGson(arrayList)
            return ItemFragment.newInstance(gsonString )
        }else{
            var gsonString = listToGson(arrayListWallpapers)
            return ItemFragment.newInstance(gsonString )
        }
    }

    private fun listToGson(list: ArrayList<DataClassWallpapers>): String {
        var gsonString = "[]"
        gsonString = Gson().toJson(list)
        return gsonString
    }
}