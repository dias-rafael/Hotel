package br.com.rafaeldias.hotel.ui.hotel

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ItemDetailBinding

class HotelDetailListAdapter2: RecyclerView.Adapter<HotelDetailListAdapter2.ViewHolder>() {
    private lateinit var hotelList:List<Hotel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelDetailListAdapter2.ViewHolder {
        val binding: ItemDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_detail, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelDetailListAdapter2.ViewHolder, position: Int) {
        holder.bind(hotelList[position])
    }

    override fun getItemCount(): Int {
        return if(::hotelList.isInitialized) hotelList.size else 0
    }

    fun updateHotelDetailList(hotelList:List<Hotel>){
        this.hotelList = hotelList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDetailBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = HotelDetailViewModel()

        fun bind(hotel:Hotel){
            viewModel.bind(hotel)
            binding.viewModel = viewModel
        }

    }
}