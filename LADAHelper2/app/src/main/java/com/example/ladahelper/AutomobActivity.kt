package com.example.ladahelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AutomobActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_automob)
        val itemsListAuto: RecyclerView = findViewById(R.id.itemsListAuto)
        val itemsAuto= arrayListOf<ItemMenu>()
        itemsAuto.add(ItemMenu(1,"kalinatwo","LADA KALINA 2"))
        itemsAuto.add(ItemMenu(2,"grantafl","LADA GRANTA FL(В разработке)"))
        itemsAuto.add(ItemMenu(3,"nivatravel","LADA NIVA Travel(В разработке)"))
        itemsAuto.add(ItemMenu(4,"vesta","LADA VESTA(В разработке)"))
        itemsAuto.add(ItemMenu(5,"niva","LADA NIVA LEGEND/4x4(В разработке)"))

        itemsListAuto.layoutManager= LinearLayoutManager(this)
        itemsListAuto.adapter = ItemsAdapter2(itemsAuto, this)
    }
}