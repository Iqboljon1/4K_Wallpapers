package com.ir.a4kwallpapers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.ir.a4kwallpapers.Adapters.AdapterViewPager
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.MyShare.MyShare
import com.ir.a4kwallpapers.databinding.FragmentHomeBinding
import com.ir.a4kwallpapers.databinding.FragmentMenuBinding

class HomeFragment : Fragment() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: FragmentHomeBinding
    lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>
    lateinit var arrayListTypes: ArrayList<String>
    private lateinit var adapterViewPager: AdapterViewPager

    @SuppressLint("WrongConstant", "InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        MyShare.init(requireActivity())


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
