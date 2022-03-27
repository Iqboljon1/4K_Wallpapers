package com.ir.a4kwallpapers.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ir.a4kwallpapers.Class.DataClassWallpapers
import com.ir.a4kwallpapers.Interface.MyWallpapersOnClickListener
import com.ir.a4kwallpapers.MenuFragment
import com.ir.a4kwallpapers.Object.Object
import com.ir.a4kwallpapers.R
import com.squareup.picasso.Picasso

class AdapterRecyclerViewWallpapers(
    val context: Context,
    val navController: NavController,
    private val arrayList: ArrayList<DataClassWallpapers>,
    val myWallpapersOnClickListener: MyWallpapersOnClickListener
) :
    RecyclerView.Adapter<AdapterRecyclerViewWallpapers.VH>() {
    inner class VH(var itemRV: View) : RecyclerView.ViewHolder(itemRV) {
        fun onBind(int: Int, position: Int) {
            val image = itemRV.findViewById<ImageView>(R.id.image_itemWallpapers)
            Picasso.get().load(int).resize(1024, 800).onlyScaleDown().centerCrop().into(image)
            itemRV.setOnClickListener {
                Object.dataClassWallpapers = DataClassWallpapers(arrayList[position].imageType,
                    arrayList[position].imageName,
                    arrayList[position].image,
                    arrayList[position].liked, arrayList[position].id)
                myWallpapersOnClickListener.onClick(navController)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayList[position].image, position)

    }

    override fun getItemCount(): Int = arrayList.size

}