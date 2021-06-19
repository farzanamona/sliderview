package com.example.smartslider

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import java.util.*

class MainActivity : AppCompatActivity() {
    var context : Context?=null
    private var imageModelArrayList: ArrayList<ImageModel>? = null

    private val myImageList = intArrayOf(R.drawable.cover, R.drawable.cover)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()

        init()

    }
    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..1) {
            val imageModel = ImageModel()
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }
    private fun init() {




        mPager = findViewById(R.id.quizeViewpager) as ViewPager
        mPager!!.adapter = SlidingImage_Adapter(this, this.imageModelArrayList!!)

        //val indicator = findViewById(R.id.indicator) as CirclePageIndicator

        // indicator.setViewPager(mPager)

        //  val density = resources.displayMetrics.density

        //Set circle indicator radius
        // indicator.setRadius(5 * density)

        NUM_PAGES = imageModelArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 1000, 1000)

        // Pager listener over indicator
//        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//
//            override fun onPageSelected(position: Int) {
//                currentPage = position
//
//            }
//
//            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {
//
//            }
//
//            override fun onPageScrollStateChanged(pos: Int) {
//
//            }
//        })

    }

    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }
}
