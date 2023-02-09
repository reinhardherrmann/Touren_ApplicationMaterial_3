package de.orome.tourenapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import de.orome.tourenapplication.databinding.ItemTourenListBinding
import de.orome.tourenapplication.domain.model.Tour
import javax.inject.Inject


class TourenListAdapter @Inject constructor() :
    RecyclerView.Adapter<TourenListAdapter.ViewHolder>() {

    private lateinit var binding: ItemTourenListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemTourenListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder()
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    inner class ViewHolder: RecyclerView.ViewHolder(binding.root) {
        fun setData(item:Tour){
            binding.apply {
                tvTourNummer.text = item.tourNummer.toString()
                tvTourDatum.text = item.tourDatum.toString()
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Tour>() {
        override fun areItemsTheSame(oldItem: Tour, newItem: Tour): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tour, newItem: Tour): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, differCallback)
}