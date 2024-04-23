package com.example.ladahelper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class ItemsAdapter(var items:List<ItemMenu>, var context: Context):RecyclerView.Adapter<ItemsAdapter.HolderView>() {
    class HolderView (view:View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title:TextView=view.findViewById(R.id.item_text_list)
        val imbut :TextView=view.findViewById(R.id.item_text_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_in_list,parent,false)
        return HolderView(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: HolderView, position: Int) {
        holder.title.text=items[position].title

        var imageId=context.resources.getIdentifier(items[position].image,"drawable",context.packageName)
        holder.image.setImageResource(imageId)

        if(holder.title.text=="Выбор автомобиля"){
            holder.imbut.setOnClickListener {
                val intent =Intent(context,AutomobActivity::class.java)
                context.startActivity(intent)
            }
        }
        if(holder.title.text=="Мои записи"){
            holder.imbut.setOnClickListener {
                val intent =Intent(context,ZapisiActivity::class.java)
                context.startActivity(intent)
            }
        }
        if(holder.title.text=="Карты"){
            holder.imbut.setOnClickListener {
                val intent =Intent(context,MapActivity::class.java)
                context.startActivity(intent)
            }
        }
        if(holder.title.text=="Поиск сервисов"){
            holder.imbut.setOnClickListener {
                val intent =Intent(context,ServiceActivity::class.java)
                context.startActivity(intent)
            }
        }

    }
}