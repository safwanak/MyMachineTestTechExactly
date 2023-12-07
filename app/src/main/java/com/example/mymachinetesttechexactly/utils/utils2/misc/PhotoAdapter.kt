package com.user.nestmarket

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.nestmarket.data.dto.marketplace.MarketPlaceDataHandler
import com.user.nestmarket.databinding.AdapterImageListBinding
import com.user.nestmarket.utils.adapter.AdapterClick
import com.user.nestmarket.utils.adapter.AdapterStringType

class PhotoAdapter(
    var context: Context,
    private val column: Int,
    marketPlaceDataHandler: MarketPlaceDataHandler
) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var dataList = emptyList<Bitmap>()
    private var marketPlaceDataHandler = MarketPlaceDataHandler()
    private var adapterClick: AdapterClick? = null

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: List<Bitmap>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    internal fun setMarketData(marketPlaceDataHandlerTemp: MarketPlaceDataHandler) {
        this.marketPlaceDataHandler.itemId.clear()
        this.marketPlaceDataHandler.itemId.addAll(marketPlaceDataHandlerTemp.itemId)
        notifyDataSetChanged()
    }


    // Provide a direct reference to each of the views with data items
    inner class PhotoViewHolder(val binding: AdapterImageListBinding) :
        RecyclerView.ViewHolder(binding.root)
    /*class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var rlParent: RelativeLayout

        init {
            image = itemView.findViewById(R.id.image)
            rlParent = itemView.findViewById(R.id.rl_parent)
        }

    }*/

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        // Inflate the custom layout
        /*val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_image_list, parent, false)
        val height = parent.width / column
        view.layoutParams.height = height*/

        /*val height = parent.width / 9
        view.layoutParams.height = height*/
        //return RecyclerView.ViewHolder(view)

        val binding = AdapterImageListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        /*val height = parent.width / column
        binding.rlParent.layoutParams.height = height*/
        return PhotoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        /*holder.binding.gridPurchased.visibility = View.GONE
        holder.binding.gridSelected.visibility = View.GONE
        holder.binding.gridUnselected.visibility = View.GONE*/

        val imageUnit = marketPlaceDataHandler.itemId[position].bitmapImage
        holder.binding.everyUnit.setImageBitmap(imageUnit)

        marketPlaceDataHandler.marketPlaceResponse.marketPlaceItem.resellKeys
        val purchasedKey = marketPlaceDataHandler.marketPlaceResponse.marketPlaceItem.smartKey
        when (purchasedKey.contains(marketPlaceDataHandler.itemId[position].id)) {
            true -> {
                /*** Already purchased Item ***/
                /*holder.binding.gridPurchased.visibility = View.VISIBLE
                holder.binding.gridPurchasedChild.image.setImageBitmap(imageUnit)*/
                holder.binding.everyUnitFront.setImageResource(R.color.already_purchased)
                holder.binding.rlParent.setOnClickListener {
                    adapterClick?.onClickAdapterChild(
                        position,
                        AdapterStringType.alreadyPurchasedUnit
                    )
                }
            }

            false -> {
                /*** Available to purchase Item ***/
                when (marketPlaceDataHandler.itemId[position].selection) {
                    true -> {
                        holder.binding.everyUnitFront.setImageResource(R.color.grid_selected)
                        /*holder.binding.gridSelected.visibility = View.VISIBLE
                        holder.binding.gridSelectedChild.image.setImageBitmap(imageUnit)*/
                    }

                    false -> {
                        holder.binding.everyUnitFront.setImageResource(R.color.grid_unselected)
                        /*holder.binding.gridUnselected.visibility = View.VISIBLE
                        holder.binding.gridUnselectedChild.image.setImageBitmap(imageUnit)*/
                    }
                }
                holder.binding.rlParent.setOnClickListener {
                    adapterClick?.onClickAdapterChild(position, AdapterStringType.availableUnit)
                }
            }
        }
    }

    override fun getItemCount() = marketPlaceDataHandler.itemId.size

    init {
        this.marketPlaceDataHandler = marketPlaceDataHandler
    }

    fun setOnClickAdapterChild(onClickAdapterChild: AdapterClick) {
        this.adapterClick = onClickAdapterChild
    }
}