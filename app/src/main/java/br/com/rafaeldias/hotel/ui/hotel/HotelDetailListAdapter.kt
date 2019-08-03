package br.com.rafaeldias.hotel.ui.hotel

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rafaeldias.cvchotel.ui.model.HoteisList
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ItemDetailBinding

class HotelDetailListAdapter: RecyclerView.Adapter<HotelDetailListAdapter.ViewHolder>() {
    private lateinit var hotelDetail:List<Hotel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelDetailListAdapter.ViewHolder {
        val binding: ItemDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_detail, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelDetailListAdapter.ViewHolder, position: Int) {
        holder.bind(hotelDetail[position])
    }

    override fun getItemCount(): Int {
        return if(::hotelDetail.isInitialized) hotelDetail.size else 0
    }

    fun updateHotelDetailList(hotelDetailList:List<Hotel>){
        this.hotelDetail = hotelDetailList
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