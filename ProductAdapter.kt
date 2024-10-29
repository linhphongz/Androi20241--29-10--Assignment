package com.example.bai229_10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class ProductAdapter(private val context: Context, private val products: List<Product>) : BaseAdapter() {

    override fun getCount() = products.size

    override fun getItem(position: Int) = products[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.itembox_layout, parent, false)
        val product = products[position]

        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvAvailability: TextView = view.findViewById(R.id.tvAvailability)
        val ivOnSale: CheckBox = view.findViewById(R.id.ivOnSale)

        tvName.text = product.name
        tvPrice.text = product.price
        tvAvailability.text = if (1 == 1) "Available" else "Out of Stock"
        ivOnSale.isChecked = product.isOnSale

        return view
    }
}
