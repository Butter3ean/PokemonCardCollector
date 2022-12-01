package com.example.pokemoncardcollector.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.viewmodels.CardViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class ListAdapter(
    private val cardViewModel: CardViewModel
) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var cardList = emptyList<Card>()
    private val picasso: Picasso = Picasso.get()

    //creates a view holder for the recyclerView with the necessary views
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val priceText: TextView = itemView.findViewById(R.id.tvPrice)
        val imageView: ImageView = itemView.findViewById(R.id.cardImage)
        val gridItem: LinearLayout = itemView.findViewById(R.id.gridItem)

    }

    //creates the view for the recylcerView with the appropriate layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_row, parent, false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //gets the current item in the card list and adds the information needed for the views fields
        val currentItem = cardList[position]
        val decimalFormat = DecimalFormat("0.00")
        holder.priceText.text = "$ ${decimalFormat.format(currentItem.price)}"
        picasso.load(currentItem.images)
            .into(holder.imageView)

        //Long clicking on a card in the recyclerView will ask the user is they want to delete a card,
        //if confirmed, the card will be deleted from the database
        holder.gridItem.setOnLongClickListener {
            notifyDataSetChanged()
            val snack = Snackbar.make(it, "Delete ${currentItem.name}?", Snackbar.LENGTH_LONG)
            snack.setAction("Confirm") {
                cardViewModel.deleteCard(currentItem)
            }
            snack.show()
            return@setOnLongClickListener true
        }

        //WHen clicking on a card in the recyclerView, it will bring the user to a fragment that shows
        // a larger picture of the card with more information about the card
        holder.gridItem.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToInfoFragment(currentItem)
            holder.gridItem.findNavController().navigate(action)

        }
    }

    //returns the size of all the items in the list
    override fun getItemCount(): Int {
        return cardList.size
    }

    //sets data from the database to the list of cards
    @SuppressLint("NotifyDataSetChanged")
    fun setData(cards: List<Card>) {
        this.cardList = cards
        notifyDataSetChanged()
    }

}








