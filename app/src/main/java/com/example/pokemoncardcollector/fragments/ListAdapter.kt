package com.example.pokemoncardcollector.fragments

import android.annotation.SuppressLint
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.example.pokemoncardcollector.viewmodels.ImageViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class ListAdapter(
    private val cardViewModel: CardViewModel
) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var cardList = emptyList<Card>()
    private val picasso: Picasso = Picasso.get()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val priceText: TextView = itemView.findViewById(R.id.tvPrice)
        val imageView: ImageView = itemView.findViewById(R.id.cardImage)
        val gridItem: LinearLayout = itemView.findViewById(R.id.gridItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = cardList[position]
        val decimalFormat = DecimalFormat("0.00")
        holder.priceText.text = "$ ${decimalFormat.format(currentItem.price)}"
        picasso.load(currentItem.images)
            .into(holder.imageView)

        holder.gridItem.setOnLongClickListener {
            notifyDataSetChanged()
            val snack = Snackbar.make(it, "Delete Card?", Snackbar.LENGTH_LONG)
            snack.setAction("Confirm") {
                cardViewModel.deleteCard(currentItem)
            }
            snack.show()
            return@setOnLongClickListener true
        }

        holder.gridItem.setOnClickListener {

            val action = ListFragmentDirections.actionListFragmentToInfoFragment(currentItem)
            holder.gridItem.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(cards: List<Card>) {
        this.cardList = cards
        notifyDataSetChanged()
    }


}








