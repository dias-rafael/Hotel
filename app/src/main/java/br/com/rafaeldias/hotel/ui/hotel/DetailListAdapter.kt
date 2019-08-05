package br.com.rafaeldias.hotel.ui.hotel

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.rafaeldias.cvchotel.ui.model.Room
import br.com.rafaeldias.hotel.R
import br.com.rafaeldias.hotel.databinding.ItemDetailBinding

class DetailListAdapter: RecyclerView.Adapter<DetailListAdapter.ViewHolder>() {
    private lateinit var detailList: List<Room>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDetailBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_detail, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(detailList[position])
    }

    override fun getItemCount(): Int {
        return if (::detailList.isInitialized) detailList.size else 0
    }

    fun updateDetailList(detailList: List<Room>) {
        this.detailList = detailList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = DetailViewModel()

        fun bind(detail: Room) {
            viewModel.bind(detail)
            binding.viewModelDetail = viewModel
        }

    }
}