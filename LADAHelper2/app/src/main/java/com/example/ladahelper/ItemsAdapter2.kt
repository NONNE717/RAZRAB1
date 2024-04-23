package com.example.ladahelper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter2(var itemsAuto:List<ItemMenu>, var context: Context): RecyclerView.Adapter<ItemsAdapter2.HolderView2>() {
    class HolderView2 (view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_list_image_auto)
        val title: TextView =view.findViewById(R.id.item_text_list_auto)
        val imbut :TextView=view.findViewById(R.id.item_text_list_auto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HolderView2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_in_list_autos,parent,false)
        return HolderView2(view)
    }

    override fun getItemCount(): Int {
        return itemsAuto.count()
    }

    override fun onBindViewHolder(holder: HolderView2, position: Int) {
        holder.title.text=itemsAuto[position].title

        var imageId=context.resources.getIdentifier(itemsAuto[position].image,"drawable",context.packageName)
        holder.image.setImageResource(imageId)

        if(holder.title.text=="LADA KALINA 2"){
            holder.imbut.setOnClickListener {
                val intent = Intent(context,PolomkiActivity::class.java)
                context.startActivity(intent)
            }
        }
    }


}