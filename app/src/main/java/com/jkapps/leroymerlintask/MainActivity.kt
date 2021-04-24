package com.jkapps.leroymerlintask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jkapps.leroymerlintask.adapter.CatalogItemAdapter
import com.jkapps.leroymerlintask.adapter.CategoryItemAdapter
import com.jkapps.leroymerlintask.entity.CatalogItem
import com.jkapps.leroymerlintask.entity.CategoryItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = listOf(
            CategoryItem(title = "Сад", image = ""),
            CategoryItem(title = "Сад", image = ""),
            CategoryItem(title = "Сад", image = ""),
        )

        val items = listOf(
            CatalogItem(image = "", price = "415 Р/шт.", name = "Декоративный предмет Frank Папоротник 06646"),
            CatalogItem(image = "", price = "415 Р/шт.", name = "Декоративный предмет Frank Папоротник 06646"),
            CatalogItem(image = "", price = "415 Р/шт.", name = "Декоративный предмет Frank Папоротник 06646"),
            CatalogItem(image = "", price = "415 Р/шт.", name = "Декоративный предмет Frank Папоротник 06646"),
            CatalogItem(image = "", price = "415 Р/шт.", name = "Декоративный предмет Frank Папоротник 06646")
        )

        val decoration = HorizontalOffsetDecoration(start = 16.toPx(), end = 16.toPx(), between = 12.toPx())

        findViewById<RecyclerView>(R.id.rv_catalog_category).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = CategoryItemAdapter(categories).apply { addItemDecoration(decoration) }
        }
        findViewById<RecyclerView>(R.id.rv_recently_viewed).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = CatalogItemAdapter(items.take(1)).apply { addItemDecoration(decoration) }
        }
        findViewById<RecyclerView>(R.id.rv_limited_offer).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = CatalogItemAdapter(items).apply { addItemDecoration(decoration) }
        }
        findViewById<RecyclerView>(R.id.rv_best_price).apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = CatalogItemAdapter(items).apply { addItemDecoration(decoration) }
        }
    }

}