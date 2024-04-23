package com.example.ladahelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val itemsList:RecyclerView = findViewById(R.id.itemsList)
        val items= arrayListOf<ItemMenu>()
        items.add(ItemMenu(1,"autos","Выбор автомобиля"))
        items.add(ItemMenu(2,"serves","Поиск сервисов"))
        items.add(ItemMenu(3,"notes","Мои записи"))
        items.add(ItemMenu(4,"maps","Карты"))
        items.add(ItemMenu(5,"denga","Расходы(В разработке)"))

        itemsList.layoutManager=LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}