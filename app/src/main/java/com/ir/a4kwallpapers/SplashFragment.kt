package com.ir.a4kwallpapers

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ir.a4kwallpapers.Object.Object
import com.ir.a4kwallpapers.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
    var countDownTimer = object : CountDownTimer(500 , 100){
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            findNavController().navigate(R.id.action_splashFragment_to_menuFragment)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)

        countDownTimer.start()

        return binding.root
    }

}