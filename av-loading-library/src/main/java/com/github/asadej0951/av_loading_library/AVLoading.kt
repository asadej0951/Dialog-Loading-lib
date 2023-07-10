package com.github.asadej0951.av_loading_library

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import com.github.asadej0951.av_loading_library.indicators.*

@SuppressLint("StaticFieldLeak")
object AVLoading {

    private var dialog: AppCompatDialog? = null
    private var context: Context? = null
    private var type: TypeIndicator? = null
    private lateinit var loader: AVLoadingIndicatorView
    private var color: Int = Color.parseColor("#000000")

    fun loadingParamsBuilder(context: Context, type: TypeIndicator, color: Int){
        this.context = context
        this.type = type
        this.color = color
    }

    @SuppressLint("ResourceType")
    fun initializeAVLoading() {
        if(context != null){
            val v = LayoutInflater.from(context).inflate(R.layout.progress_loading, null)
            loader = v.findViewById(R.id.avl_loading)
            dialog = AppCompatDialog(context!!)
            dialog!!.setCancelable(false)
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            if(type != null){
                when (type) {
                    TypeIndicator.BallBeatIndicator -> loader.indicator = BallBeatIndicator()
                    TypeIndicator.BallClipRotateIndicator -> loader.indicator = BallClipRotateIndicator()
                    TypeIndicator.BallClipRotateMultipleIndicator -> loader.indicator = BallClipRotateMultipleIndicator()
                    TypeIndicator.BallClipRotatePulseIndicator -> loader.indicator = BallClipRotatePulseIndicator()
                    TypeIndicator.BallGridBeatIndicator -> loader.indicator = BallGridBeatIndicator()
                    TypeIndicator.BallGridPulseIndicator -> loader.indicator = BallGridPulseIndicator()
                    TypeIndicator.BallPulseIndicator -> loader.indicator = BallPulseIndicator()
                    TypeIndicator.BallPulseRiseIndicator -> loader.indicator = BallPulseRiseIndicator()
                    TypeIndicator.BallPulseSyncIndicator -> loader.indicator = BallPulseSyncIndicator()
                    TypeIndicator.BallScaleMultipleIndicator -> loader.indicator = BallScaleMultipleIndicator()
                    else -> {}
                }
            }
            if(color != null){
                loader.indicator!!.color = color
            }
            dialog!!.context.setTheme(R.style.Theme_MyApplication)
            dialog!!.setContentView(v)
        }
    }

    fun startAnimLoading() {
        try {
            if (dialog != null && !dialog!!.isShowing) {
                dialog!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun stopAnimLoading() {
        try {
            if (dialog != null && dialog!!.isShowing) {
                dialog!!.dismiss()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}