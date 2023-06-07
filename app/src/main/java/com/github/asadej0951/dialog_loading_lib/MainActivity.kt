package com.github.asadej0951.dialog_loading_lib

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.asadej0951.av_loading_library.AVLoading
import com.github.asadej0951.av_loading_library.TypeIndicator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AVLoading.loadingParamsBuilder(this,
            TypeIndicator.BallScaleMultipleIndicator, Color.parseColor("#FFFFFF"))
        AVLoading.initializeAVLoading()

       findViewById<Button>(R.id.btnStart).setOnClickListener {
            AVLoading.startAnimLoading()
        }

        findViewById<Button>(R.id.btnStop).setOnClickListener {
            AVLoading.stopAnimLoading()
        }
    }
}