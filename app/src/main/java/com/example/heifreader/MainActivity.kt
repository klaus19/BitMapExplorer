package com.example.heifreader



import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.Bitmap.createBitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import androidx.annotation.RequiresApi
import com.example.heifreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bm: Bitmap
    lateinit var canvas: Canvas
   // lateinit var newBmp: Bitmap



    @RequiresApi(Build.VERSION_CODES.Q)
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

            diagonalCarrom(binding.imageBitmap)
        }

        binding.imageBitmap.setOnTouchListener { _, event ->
            if (event!!.action == MotionEvent.ACTION_MOVE) {
                val p = Paint(Color.GREEN)
                canvas.drawCircle(50f, 50f, 25f, p)
               val touch =  ObjectAnimator.ofFloat(binding.imageBitmap, "translationX", -110f)
                       touch.interpolator = BounceInterpolator()
                touch.duration = 1000
                    touch.start()


            }
            true

        }

    }


    //Creating a customised BitMap and showing it in imageView
    private fun createBitmap() {
        bm = createBitmap(100, 100, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bm)
        canvas.drawColor(Color.parseColor("#fff9c4"))
        binding.imageBitmap.visibility = View.VISIBLE
        binding.imageBitmap.setImageBitmap(bm)
        val obj = ObjectAnimator.ofFloat(binding.imageBitmap,"translationX", 110f)
        obj.duration = 500
            obj.start()
    }

/*Setting drawable Image into imageview programmatically
private fun settingDrawableImage() {
    val drawable = this.getDrawable(R.drawable.paper)
    binding.image1.visibility = View.VISIBLE
    binding.image1.setImageDrawable(drawable)
}*/

    //Transition through diagonally
    private fun diagonalCarrom(v:View) {
        val animatorXY = AnimatorSet()

        canvas.drawColor(Color.parseColor("#5c007a"))
        val y:ObjectAnimator = ObjectAnimator.ofFloat(v,"translationY",v.y,110f)
        val x:ObjectAnimator = ObjectAnimator.ofFloat(v,"translationX",v.x,110f)

        animatorXY.playTogether(x,y)
        animatorXY.duration = 1000
        animatorXY.start()
    }
}

