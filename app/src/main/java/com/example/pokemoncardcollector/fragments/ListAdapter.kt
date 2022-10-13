//package com.example.pokemoncardcollector.fragments
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.pokemoncardcollector.R
//import com.example.pokemoncardcollector.entities.Card
//import com.squareup.picasso.Picasso
//
//class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
//
//    private var cardList = emptyList<Card>()
//    val picasso = Picasso.get()
//
//    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//
//        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = cardList[position]
//        holder.itemView.findViewById<TextView>(R.id.tvCardName).text = currentItem.name
//        picasso.load(currentItem.images).into(holder.itemView.findViewById<ImageView>(R.id.cardImage))
//    }
//
//    override fun getItemCount(): Int {
//        return cardList.size
//    }
//
//    fun setData(cards: List<Card>) {
//        this.cardList = cards
//        notifyDataSetChanged()
//    }
//}