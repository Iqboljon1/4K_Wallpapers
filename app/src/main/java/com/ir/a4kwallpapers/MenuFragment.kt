package com.ir.a4kwallpapers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.MyShare.MyShare
import com.ir.a4kwallpapers.databinding.FragmentMenuBinding
import eightbitlab.com.blurview.RenderScriptBlur

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
    lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        MyShare.init(requireActivity())
        arrayListWallpapers = ArrayList()
        navHostFragment = childFragmentManager.findFragmentById(R.id.fragmentNavigation) as NavHostFragment
        navController = navHostFragment.navController
        arrayListWallpapers.addAll(MyShare.dataList!!)

        buildBlurView()
        fragmentNavigation(0)

        binding.imageHomeBottom.setOnClickListener {
            fragmentNavigation(0)
        }

        binding.imagePopularBottom.setOnClickListener {
            fragmentNavigation(1)
        }

        binding.imageRandomBottom.setOnClickListener {
            fragmentNavigation(2)
        }

        binding.imageLikedBottom.setOnClickListener {
            fragmentNavigation(3)
        }

        binding.lyHome.setOnClickListener {
            fragmentNavigation(0)
            binding.drawerLayout.closeDrawer(Gravity.START)
        }

        binding.lyPopular.setOnClickListener {
            fragmentNavigation(1)
            binding.drawerLayout.closeDrawer(Gravity.START)
        }

        binding.lyRandom.setOnClickListener {
            fragmentNavigation(2)
            binding.drawerLayout.closeDrawer(Gravity.START)
        }

        binding.lyLiked.setOnClickListener {
            fragmentNavigation(3)
            binding.drawerLayout.closeDrawer(Gravity.START)
        }

        return binding.root
    }

    private fun fragmentNavigation(int: Int) {

        binding.imageHomeBottomIndicator.visibility = View.INVISIBLE
        binding.imageHomePopularIndicator.visibility = View.INVISIBLE
        binding.imageHomeRandomIndicator.visibility = View.INVISIBLE
        binding.imageHomeLikedIndicator.visibility = View.INVISIBLE
        when (int) {
            0 -> {
                binding.imageHomeBottomIndicator.visibility = View.VISIBLE
                navController.navigate(R.id.homeFragment)
            }
            1 -> {
                binding.imageHomePopularIndicator.visibility = View.VISIBLE
                navController.navigate(R.id.popularFragment)
            }
            2 -> {
                binding.imageHomeRandomIndicator.visibility = View.VISIBLE
                navController.navigate(R.id.randomFragment)
            }
            3 -> {
                binding.imageHomeLikedIndicator.visibility = View.VISIBLE
                navController.navigate(R.id.likedFragment)
            }
        }
    }

    private fun buildBlurView() {

        val radius = 20f

        val decorView: View = requireActivity().window.decorView

        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup

        val windowBackground = decorView.background

        binding.blurView.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)
    }

}