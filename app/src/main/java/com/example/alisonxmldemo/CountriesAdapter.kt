package com.example.alisonxmldemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(
    val countryNameList: ArrayList<String>,
    val detailsList: ArrayList<String>,
    val imagesList: ArrayList<Int>,
    val context: Context
) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {
        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewDetails.text = detailsList.get(position)
        holder.imageView.setImageResource(imagesList.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected ${countryNameList.get(position)}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewCountryName: TextView = itemView.findViewById(R.id.textViewCountryName)
        var textViewDetails: TextView = itemView.findViewById(R.id.detailsTextView)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}