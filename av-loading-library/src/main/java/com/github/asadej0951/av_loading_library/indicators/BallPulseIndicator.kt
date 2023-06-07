package com.github.asadej0951.av_loading_library.indicators

import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.graphics.Canvas
import android.graphics.Paint
import com.github.asadej0951.av_loading_library.Indicator

class BallPulseIndicator : Indicator() {
    //scale x ,y
    private val scaleFloats = floatArrayOf(
        SCALE,
        SCALE,
        SCALE
    )

    override fun draw(canvas: Canvas?, paint: Paint?) {
        val circleSpacing = 4f
        val radius: Float = (width.coerceAtMost(height) - circleSpacing * 2) / 6
        val x: Float = width / 2 - (radius * 2 + circleSpacing)
        val y: Float = (height / 2).toFloat()
        for (i in 0..2) {
            canvas?.save()
            val translateX = x + radius * 2 * i + circleSpacing * i
            canvas?.translate(translateX, y)
            canvas?.scale(scaleFloats[i], scaleFloats[i])
            canvas?.drawCircle(0f, 0f, radius, paint!!)
            canvas?.restore()
        }
    }

    override fun onCreateAnimators(): ArrayList<ValueAnimator> {
        val animators = ArrayList<ValueAnimator>()
        val delays = intArrayOf(120, 240, 360)
        for (i in 0..2) {
            val scaleAnim = ValueAnimator.ofFloat(1f, 0.3f, 1f)
            scaleAnim.duration = 750
            scaleAnim.repeatCount = -1
            scaleAnim.startDelay = delays[i].toLong()
            addUpdateListener(scaleAnim,
                AnimatorUpdateListener { animation ->
                    scaleFloats[i] = animation.animatedValue as Float
                    postInvalidate()
                })
            animators.add(scaleAnim)
        }
        return animators
    }

    companion object {
        const val SCALE = 1.0f
    }
}
