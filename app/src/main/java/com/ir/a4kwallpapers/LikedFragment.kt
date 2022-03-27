package com.ir.a4kwallpapers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ir.a4kwallpapers.Adapters.AdapterViewPager
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.MyShare.MyShare
import com.ir.a4kwallpapers.databinding.FragmentLikedBinding


class LikedFragment : Fragment() {
    lateinit var binding: FragmentLikedBinding
    private lateinit var drawerLayout: DrawerLayout
    lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>
    lateinit var arrayListTypes: ArrayList<String>
    private lateinit var adapterViewPager: AdapterViewPager

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLikedBinding.inflate(layoutInflater)

        binding.imageItem.setOnClickListener {
            drawerLayout = requireActivity().findViewById(R.id.drawerLayout)
            drawerLayout.openDrawer(Gravity.START)
        }

        createData()

        adapterViewPager = AdapterViewPager(arrayListTypes, arrayListWallpapers, requireActivity())
        binding.viewPager.adapter = adapterViewPager

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = arrayListTypes[position]
        }.attach()

        return binding.root
    }

    private fun createData() {
        arrayListWallpapers = ArrayList()
        arrayListTypes = ArrayList()
        arrayListWallpapers.addAll(MyShare.dataList!!)
        arrayListTypes = buildArrayListTypes()
        arrayListWallpapers = loadLiked(arrayListWallpapers)
    }

    private fun loadLiked(arrayListWallpapers: ArrayList<DataClassWallpapers>): ArrayList<DataClassWallpapers> {
        var arrayList = ArrayList<DataClassWallpapers>()
        for (i in arrayListWallpapers) {
            if (i.liked){
                arrayList.add(i)
            }
        }
        return arrayList
    }

    private fun buildArrayListTypes(): ArrayList<String> {
        val arrayList = ArrayList<String>()
        val hashSet = HashSet<String>()
        arrayList.add("All")
        for (i in arrayListWallpapers) {
            val boolean = hashSet.add(i.imageType)
            if (boolean) {
                arrayList.add(i.imageType)
            }
        }
        return arrayList
    }

}