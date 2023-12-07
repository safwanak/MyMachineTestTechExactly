package com.user.nestmarket

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
//import com.user.nestmarket.data.dto.marketplace.MarketPlaceDataHandler
import com.user.nestmarket.utils.adapter.AdapterClick
import com.user.nestmarket.utils.adapter.AdapterStringType

//class ImageAdapter(
//    private val mActivity: Activity,
//    private val mColumn: Int,
//    private val marketPlaceDataHandler: MarketPlaceDataHandler
//) : BaseAdapter() {
//    private var adapterClick: AdapterClick? = null
//    override fun getCount(): Int {
//        return marketPlaceDataHandler.itemId.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return marketPlaceDataHandler.itemId[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    @SuppressLint("UseCompatLoadingForDrawables")
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        var myView = convertView
//        var holder: ViewHolder
//
//        if (myView == null) {
//
//            val mInflater = mActivity.layoutInflater
//            myView = mInflater.inflate(R.layout.adapter_image_list, parent, false)
//            holder = ViewHolder()
//
//            holder.mEveryUnit = myView!!.findViewById<ImageView>(R.id.everyUnit) as ImageView
//            holder.mEveryFront = myView.findViewById<ImageView>(R.id.everyUnitFront) as ImageView
//            holder.mRlParent = myView.findViewById<RelativeLayout>(R.id.rl_parent) as RelativeLayout
//            myView.tag = holder
//        } else {
//            holder = myView.tag as ViewHolder
//
//        }
//
//        holder.mEveryUnit!!.setImageBitmap(marketPlaceDataHandler.itemId[position].bitmapImage)
//        marketPlaceDataHandler.marketPlaceResponse.marketPlaceItem.resellKeys
//        val purchasedKey = marketPlaceDataHandler.marketPlaceResponse.marketPlaceItem.smartKey
//        when (purchasedKey.contains(marketPlaceDataHandler.itemId[position].id)) {
//            true -> {
//                /*** Already purchased Item ***/
//                holder.mEveryFront!!.setImageResource(R.color.already_purchased)
//                holder.mRlParent!!.setOnClickListener {
//                    adapterClick?.onClickAdapterChild(
//                        position,
//                        AdapterStringType.alreadyPurchasedUnit
//                    )
//                }
//
//            }
//
//            false -> {
//                /*** Available to purchase Item ***/
//                when (marketPlaceDataHandler.itemId[position].selection) {
//                    true -> {
//                        holder.mEveryFront!!.setImageResource(R.color.grid_selected)
//                    }
//
//                    false -> {
//                        holder.mEveryFront!!.setImageResource(R.color.grid_unselected)
//                    }
//                }
//                holder.mRlParent!!.setOnClickListener {
//                    marketPlaceDataHandler.itemId[position].selection =
//                        !marketPlaceDataHandler.itemId[position].selection
//                    when (marketPlaceDataHandler.itemId[position].selection) {
//                        true -> {
//                            holder.mEveryFront!!.setImageResource(R.color.grid_selected)
//                        }
//
//                        false -> {
//                            holder.mEveryFront!!.setImageResource(R.color.grid_unselected)
//                        }
//                    }
//                    adapterClick?.onClickAdapterChild(position, AdapterStringType.refreshChanges)
//                }
//            }
//        }
//        return myView
//    }
//
//    fun setOnClickAdapterChild(onClickAdapterChild: AdapterClick) {
//        this.adapterClick = onClickAdapterChild
//    }
//
//    class ViewHolder {
//        var mEveryUnit: ImageView? = null
//        var mRlParent: RelativeLayout? = null
//        var mEveryFront: ImageView? = null
//    }
//}