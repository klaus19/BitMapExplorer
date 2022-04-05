package com.example.heifreader


import android.animation.ObjectAnimator
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            settingDrawableImage()
        }

       binding.createBitMap.setOnClickListener {
            createBitmap()
       }


    }

      //Creating a customised BitMap and showing it in imageView
    private fun createBitmap() {
        val bm:Bitmap = createBitmap(100,100,Bitmap.Config.ARGB_8888)
        val canvas:Canvas = Canvas(bm)
        canvas.drawColor(Color.BLUE)
        binding.imageBitmap.setImageBitmap(bm)
    }

    //Setting drawable Image into imageview programmatically
    private fun settingDrawableImage() {

        val drawable = this.getDrawable(R.drawable.paper)

        binding.image1.visibility = View.VISIBLE
        binding.image1.setImageDrawable(drawable)

    }






}