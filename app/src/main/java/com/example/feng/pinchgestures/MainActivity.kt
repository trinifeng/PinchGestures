package com.example.feng.pinchgestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView

var scale: Float = 1.0f
lateinit var image: ImageView

lateinit var myScaleDetector: ScaleGestureDetector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.raccoon_image)
        myScaleDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        myScaleDetector.onTouchEvent(event!!)
        return super.onTouchEvent(event)
    }

    class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale, 5.0f))
            image.scaleX = scale
            image.scaleY = scale

            return true
        }

    }
}