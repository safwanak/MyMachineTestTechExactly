package com.user.nestmarket.utils

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import com.user.nestmarket.utils.localsp.GetAndSetSP
import com.user.nestmarket.utils.network.NetworkToken
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import java.util.TreeSet

//object Helper {
//
//    fun printLowest(arrList: ArrayList<Double>, number: Double): Double {
//        return TreeSet(arrList).lower(number)
//    }
//
//    fun overrideOptions(): RequestOptions {
//        return RequestOptions().override(200 * 200)
//    }
//
//    fun twoDigits(data: Any?): String {
//        if (data == null) {
//            return "0.0"
//        } else {
//            return when (data) {
//                is String -> {
//                    when (data) {
//                        "" -> {
//                            ""
//                        }
//
//                        else -> {
//                            DecimalFormat("#0.00").format(data.toFloat())
//                        }
//                    }
//
//                }
//
//                is Float -> {
//                    DecimalFormat("#0.00").format(data.toFloat())
//                }
//
//                is Double -> {
//                    DecimalFormat("#0.00").format(data.toDouble())
//                }
//
//                else -> {
//                    DecimalFormat("#0.00").format(data)
//                }
//            }
//        }
//
//    }
//
//    fun toHelperDouble(data: Any?): Double {
//        if (data == null) {
//            return 0.00
//        } else {
//            return when (data) {
//                is String -> {
//                    when (data) {
//                        "" -> {
//                            0.00
//                        }
//
//                        else -> {
//                            data.toDouble()
//                        }
//                    }
//
//                }
//
//                is Float -> {
//                    data.toDouble()
//                }
//
//                is Double -> {
//                    data.toDouble()
//                }
//
//                is Long -> {
//                    data.toDouble()
//                }
//
//                else -> {
//                    data.toString().toDouble()
//                }
//            }
//        }
//
//    }
//
//    fun convertToDate(inputDate: String): String? {
//        val sdf =
//            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//        sdf.timeZone = TimeZone.getTimeZone("UTC")
//        var date: Date? = null
//        try {
//            date = sdf.parse(inputDate)
//        } catch (e: Exception) {
//            //date format error
//        }
//        // dd MMM yyyy(24 Jan 2017)
//        val format = SimpleDateFormat("MMMM dd, yyyy hh:mm a")
//        return date?.let { format.format(it) }
//    }
//
//    fun <T : Any> clearAllActivity(mActivity: T) {
//        val intent = Intent(mActivity as AppCompatActivity, LoginSignUpActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        GetAndSetSP(mActivity).setSP(
//            NetworkToken.netWorkTokenTitle,
//            NetworkToken.netWorkToken,
//            ""
//        )
//        /*** From Right to Right ***/
//        val options = ActivityOptions.makeCustomAnimation(
//            mActivity as AppCompatActivity,
//            R.anim.push_right_in,
//            R.anim.push_right_out,
//        )
//        mActivity.startActivity(intent, options.toBundle())
//    }
//
//    fun loadWithCustomGlideSettings(mContext: Context, imageUrl: String, imageView: ImageView) {
//        Glide.with(mContext)
//            .load(imageUrl)
//            .fitCenter()
//            .thumbnail(0.5f)
//            .placeholder(R.drawable.ic_uploaddefault)
//            /*Testing Start*/
//            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//            .skipMemoryCache(false)
//            /*Testing End*/
//            .into(imageView)
//    }
//
//}
