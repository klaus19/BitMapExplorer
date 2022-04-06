package com.example.heifreader


import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.Bitmap.createBitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.health.HealthStats
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import com.example.heifreader.databinding.ActivityMainBinding
import com.google.android.material.circularreveal.CircularRevealRelativeLayout

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var bm:Bitmap
    lateinit var canvas: Canvas


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        binding.button.setOnClickListener {
            settingDrawableImage()
        } */

       binding.createBitMap.setOnClickListener {
            createBitmap()
       }

        binding.imageBitmap.setOnTouchListener { _, event ->
            if (event!!.action == MotionEvent.ACTION_MOVE) {
                canvas.drawColor(Color.parseColor("#bf5f82"))
                ObjectAnimator.ofFloat(binding.imageBitmap, "translationY", 110f)
                    .setDuration(1000)
                    .start()

            }


            true
        }


    }

      //Creating a customised BitMap and showing it in imageView
    private fun createBitmap() {
         bm = createBitmap(100,100,Bitmap.Config.ARGB_8888)
        canvas = Canvas(bm)
        canvas.drawColor(Color.parseColor("#fff9c4"))
          binding.imageBitmap.visibility = View.VISIBLE
        binding.imageBitmap.setImageBitmap(bm)
          ObjectAnimator.ofFloat(binding.imageBitmap,"translationX",110f)
              .setDuration(500)
              .start()
    }

    /*Setting drawable Image into imageview programmatically
    private fun settingDrawableImage() {

        val drawable = this.getDrawable(R.drawable.paper)

        binding.image1.visibility = View.VISIBLE
        binding.image1.setImageDrawable(drawable)

    }*/







}