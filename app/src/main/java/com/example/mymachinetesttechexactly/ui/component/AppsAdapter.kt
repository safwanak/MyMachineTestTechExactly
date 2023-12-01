package com.example.mymachinetesttechexactly.ui.component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mymachinetesttechexactly.data.dto.App
import com.example.mymachinetesttechexactly.data.dto.AppResponse
import com.example.mymachinetesttechexactly.data.dto.Data
import com.example.mymachinetesttechexactly.databinding.ListItemAppsBinding

class AppsAdapter(
    private val mContext: Context,
    mData: List<App>,
) : RecyclerView.Adapter<AppsAdapter.MenuViewHolder>(), Filterable {
    private var originalList: List<App> = mutableListOf()
    private var filteredList: List<App> = mutableListOf()

//    private var adapterClick: AdapterClick? = null

    private val VIEW_TYPE_EMPTY = 1
    private val VIEW_TYPE_EVENT = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding =
            ListItemAppsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when(viewType){
            VIEW_TYPE_EMPTY ->{
                holder.binding.item.visibility = View.GONE
                holder.binding.noItem.visibility = View.VISIBLE
            }
            else ->{
                val commentInfo = filteredList[position]
                holder.binding.name.text = commentInfo.app_name
                Glide.with(mContext)
                    .load(commentInfo.app_icon)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(false)
                    .into(holder.binding.appIcon)
                if(commentInfo.status.equals("Active")){
                    holder.binding.appSwitch.setChecked(true)
                }else{
                    holder.binding.appSwitch.setChecked(true)
                }
            }
        }


        }


    override fun getItemCount(): Int {
        return if (filteredList.isEmpty()) {
            1
        } else {
            filteredList.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (filteredList.isEmpty()) {
            VIEW_TYPE_EMPTY
        } else {
            VIEW_TYPE_EVENT
        }
    }

    inner class MenuViewHolder(val binding: ListItemAppsBinding) :
        RecyclerView.ViewHolder(binding.root)

    init {
        this.originalList = mData
        this.filteredList = originalList
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredResults = mutableListOf<App>()

                if (constraint.isNullOrBlank()) {
                    filteredResults.addAll(originalList)
                } else {
                    val filterPattern = constraint.toString().toLowerCase().trim()
                    for (item in originalList) {
                        if (item.app_name.toLowerCase().contains(filterPattern)) {
                            filteredResults.add(item)
                        }
                    }
                }

                val results = FilterResults()
                results.values = filteredResults
                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<App>
                notifyDataSetChanged()
            }
        }
    }

//    fun setOnClickAdapterChild(onClickAdapterChild: AdapterClick) {
//        this.adapterClick = onClickAdapterChild
//    }
}