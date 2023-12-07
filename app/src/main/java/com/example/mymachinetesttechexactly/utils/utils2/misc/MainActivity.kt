package com.user.nestmarket

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.user.nestmarket.data.dto.marketplace.MarketPlaceDataHandler
import com.user.nestmarket.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<Bitmap>()
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiPath =
            "http://nestmarket.sgssys.info/NestImages/ddd066c3b0975f70b0c123423c7d7e37ca7fd603ec16e9d84deae38051594b67.jpg"
        Glide.with(this)
            .asBitmap()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .load(apiPath)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    splitImage(resource)
                    //imageView.setImageBitmap(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })

    }

    /*1920
    1200*/
    private fun splitImage(resource: Bitmap) {
        val chunkedImages = arrayListOf<Bitmap>()
        var yCoord = 0

        val chunkWidth = resource.width / 10
        val chunkHeight = resource.height / 10

        for (x in 0 until 10) {
            var xCoord = 0
            for (y in 0 until 10) {
                chunkedImages.add(
                    Bitmap.createBitmap(
                        resource, xCoord, yCoord, chunkWidth, chunkHeight
                    )
                )
                xCoord += chunkWidth
            }
            yCoord += chunkHeight
        }

        initializeGrid(chunkedImages)
    }

    private fun initializeGrid(chunkedImages: ArrayList<Bitmap>) {

        binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 10)
        photoAdapter = PhotoAdapter(applicationContext, 10, MarketPlaceDataHandler())
        binding.recyclerView.adapter = photoAdapter

        photoAdapter.setDataList(chunkedImages)
    }

}