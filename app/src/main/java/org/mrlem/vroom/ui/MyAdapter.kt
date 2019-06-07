package org.mrlem.vroom.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.mrlem.vroom.data.model.MyData

/**
 * I'm an adapter, I know how to display a single mydata on an item view!
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val myDataset = mutableListOf<MyData>()

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // bind current data to view
        holder.textView.text = myDataset[position].name
    }

    // data size
    override fun getItemCount() = myDataset.size

    fun setData(newData: List<MyData>) {
        myDataset.clear()
        myDataset.addAll(newData)
        notifyDataSetChanged()
    }

}
