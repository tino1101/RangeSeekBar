package com.tino.rangeseekbar.demo.fragments

import android.view.View
import com.tino.rangeseekbar.OnRangeChangedListener
import com.tino.rangeseekbar.RangeSeekBar
import com.tino.rangeseekbar.SeekBar
import com.tino.rangeseekbar.demo.R
import kotlinx.android.synthetic.main.fragment_range.*

class RangeSeekBarFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_range
    }

    override fun initView(view: View) {
        sb_range_1?.setProgress(0f, 100f)
        changeSeekBarThumb(sb_range_1.leftSeekBar, sb_range_1.leftSeekBar.progress)
        changeSeekBarThumb(sb_range_1.rightSeekBar, sb_range_1.rightSeekBar.progress)
        sb_range_1?.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
                changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
                changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
            }

            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

        })

        sb_range_2?.setProgress(0f, 100f)

        sb_range_3?.setRange(-100f, 100f)
        sb_range_3?.setProgress(0f, 80f)
        sb_range_3?.setIndicatorTextDecimalFormat("0")

        sb_range_4?.setProgress(20f, 70f)

        sb_range_5?.setProgress(20f, 60f)

        sb_range_6?.setProgress(20f, 70f)

        sb_range_8?.setProgress(20f, 60f)
        sb_range_8?.leftSeekBar?.thumbDrawableId = R.drawable.step_1
        sb_range_8?.rightSeekBar?.thumbDrawableId = R.drawable.step_2

    }

    private fun changeSeekBarThumb(seekbar: SeekBar, value: Float) {
        if (value < 33) {
            seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
        } else if (value < 66) {
            seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
        } else {
            seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
        }
    }

}