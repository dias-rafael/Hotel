package br.com.rafaeldias.hotel.ui.hotel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.utils.Format
import kotlinx.android.synthetic.main.item_detail.view.*

class HotelDetailListAdapter(var hotelList:List<Room>): RecyclerView.Adapter<HotelDetailListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hotelList[position])
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }

    class ViewHolder(private val binding: View):RecyclerView.ViewHolder(binding){

        fun bind(hotel:Room) = with(binding){
            tvListaTipo.text = hotel.categoryName
            tvValorQuartoAdulto.text = Format.Currency(hotel.price.adult)
            tvValorQuartoCrianca.text = Format.Currency(hotel.price.child)
        }

    }
}