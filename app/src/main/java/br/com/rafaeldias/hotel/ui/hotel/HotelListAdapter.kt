package br.com.rafaeldias.hotel.ui.hotel

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rafaeldias.cvchotel.ui.model.Hotel
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ItemHotelBinding

class HotelListAdapter: RecyclerView.Adapter<HotelListAdapter.ViewHolder>() {
    private lateinit var hotelList:List<Hotel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHotelBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_hotel, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hotelList[position])
    }

    override fun getItemCount(): Int {
        return if(::hotelList.isInitialized) hotelList.size else 0
    }

    fun updateHotelList(hotelList:List<Hotel>){
        this.hotelList = hotelList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemHotelBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = HotelViewModel()

        fun bind(hotel:Hotel){
            viewModel.bind(hotel)
            binding.viewModel = viewModel
            binding.btListaDetalhe.setOnClickListener{
                val intent = Intent(binding.btListaDetalhe.context, DetailListActivity::class.java)
                intent.putExtra("detalhe_hotel", hotel)
                binding.btListaDetalhe.context.startActivity(intent)
            }
        }

    }
}