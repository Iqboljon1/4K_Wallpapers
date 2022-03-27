package com.ir.a4kwallpapers

import android.R
import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.MyShare.MyShare
import com.ir.a4kwallpapers.Object.Object
import com.ir.a4kwallpapers.databinding.FragmentShowWallpapersBinding
import eightbitlab.com.blurview.RenderScriptBlur
import android.graphics.Bitmap

import android.provider.MediaStore.Images.Media.getBitmap

import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import java.io.IOException


class ShowWallpapersFragment : Fragment() {
    lateinit var binding: FragmentShowWallpapersBinding
    private lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentShowWallpapersBinding.inflate(layoutInflater)
        MyShare.init(requireActivity())
        buildBlurView()
        buildLiked()
        binding.imageWallpapers.setImageResource(Object.dataClassWallpapers.image)

        binding.cardViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.cardViewInstall.setOnClickListener {

        }

        return binding.root
    }

    private fun buildLiked() {
        var forLike: Int
        if (Object.dataClassWallpapers.liked) {
            binding.imageLiked.setImageResource(com.ir.a4kwallpapers.R.drawable.frame_ic_liked_click)
            forLike = 2
        } else {
            binding.imageLiked.setImageResource(com.ir.a4kwallpapers.R.drawable.frame_ic_liked)
            forLike = 1
        }

        binding.cardViewLiked.setOnClickListener {
            forLike += 1
            if (forLike % 2 == 0) {
                binding.imageLiked.setImageResource(com.ir.a4kwallpapers.R.drawable.frame_ic_liked_click)
                Object.dataClassWallpapers.liked = true
                editArrayList()
            } else {
                binding.imageLiked.setImageResource(com.ir.a4kwallpapers.R.drawable.frame_ic_liked)
                Object.dataClassWallpapers.liked = false
                editArrayList()
            }
        }


    }

    private fun editArrayList() {
        arrayListWallpapers = ArrayList()
        arrayListWallpapers.addAll(MyShare.dataList!!)
        for (i in 0 until arrayListWallpapers.size) {
            if (arrayListWallpapers[i].id == Object.dataClassWallpapers.id) {
                arrayListWallpapers[i].liked = Object.dataClassWallpapers.liked
            }
        }
        MyShare.dataList = arrayListWallpapers
    }

    private fun buildBlurView() {

        val radius = 20f

        val decorView: View = requireActivity().window.decorView

        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup

        val windowBackground = decorView.background

        binding.blurViewBack.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewShare.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewAbout.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewDownload.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewInstall.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewFilter.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)

        binding.blurViewLiked.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(requireActivity()))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)
    }

}