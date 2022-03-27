package com.ir.a4kwallpapers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ir.a4kwallpapers.Adapters.AdapterRecyclerViewWallpapers
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.Interface.MyWallpapersOnClickListener
import com.ir.a4kwallpapers.databinding.FragmentItemBinding

private const val ARG_PARAM1 = "param1"

class ItemFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    lateinit var binding: FragmentItemBinding
    private lateinit var arrayListWallpapers: ArrayList<DataClassWallpapers>
    lateinit var adapterRecyclerViewWallpapers: AdapterRecyclerViewWallpapers
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater)

        arrayListWallpapers = ArrayList()
        arrayListWallpapers = gsonToArray(param1.toString())
        adapterRecyclerViewWallpapers =
            AdapterRecyclerViewWallpapers(requireActivity(),
                requireActivity().findNavController(R.id.fragmentNavigationParent),
                arrayListWallpapers,
                object : MyWallpapersOnClickListener {
                    override fun onClick(
                        navController
                        : NavController,
                    ) {
                        navController.navigate(R.id.action_menuFragment_to_showWallpapersFragment)
                    }
                })
        binding.recyclerView.adapter = adapterRecyclerViewWallpapers
        return binding.root
    }

    companion object {

        fun newInstance(param1: String) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    fun gsonToArray(gsonString: String): ArrayList<DataClassWallpapers> {
        val list = ArrayList<DataClassWallpapers>()

        val type = object : TypeToken<List<DataClassWallpapers>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

}