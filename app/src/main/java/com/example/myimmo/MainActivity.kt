package com.example.myimmo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.properties_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.properties.observe(this) { properties ->
            recyclerView.adapter = PropertiesAdapter(properties)
        }

        viewModel.fetchProperties()
    }
}

class PropertiesAdapter(private val properties: List<Property>) :
    RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.property_name)
        val priceTextView: TextView = view.findViewById(R.id.property_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.property_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = properties[position]
        holder.nameTextView.text = property.name
        holder.priceTextView.text = "${property.price} €"
    }

    override fun getItemCount() = properties.size
}
