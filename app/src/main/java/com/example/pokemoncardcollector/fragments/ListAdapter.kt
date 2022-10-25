package com.example.pokemoncardcollector.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.dao.CardDao
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent
import org.w3c.dom.Text

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var cardList = emptyList<Card>()
    private val picasso: Picasso = Picasso.get()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val priceText: TextView = itemView.findViewById(R.id.tvPrice)
        val imageView: ImageView = itemView.findViewById(R.id.cardImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = cardList[position]

        holder.priceText.append(currentItem.price.toString())
        picasso.load(currentItem.images)
            .into(holder.imageView)


    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun setData(cards: List<Card>) {
        this.cardList = cards
        notifyDataSetChanged()
    }

}








