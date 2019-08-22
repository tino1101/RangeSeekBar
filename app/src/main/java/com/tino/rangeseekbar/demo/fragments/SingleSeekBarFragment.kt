package com.tino.rangeseekbar.demo.fragments

import android.graphics.Typeface
import android.view.View
import com.tino.rangeseekbar.OnRangeChangedListener
import com.tino.rangeseekbar.RangeSeekBar
import com.tino.rangeseekbar.demo.R
import kotlinx.android.synthetic.main.fragment_single.*

class SingleSeekBarFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_single
    }

    override fun initView(view: View) {
        sb_single1?.setProgress(10f)
        sb_single2?.setProgress(20f)
        sb_single3?.setProgress(30f)
        sb_single4?.setProgress(40f)
        sb_single4?.setIndicatorTextDecimalFormat("0.00")
        sb_single4?.setIndicatorTextStringFormat("%s%%")
        sb_single5?.setIndicatorTextDecimalFormat("0")

        sb_single6?.setTypeface(Typeface.SANS_SERIF)
        sb_single6?.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
                when {
                    leftValue < 33.33 -> rangeSeekBar.leftSeekBar.setIndicatorText("赶往店中")
                    leftValue < 66.66 -> rangeSeekBar.leftSeekBar.setIndicatorText("制作中")
                    else -> rangeSeekBar.leftSeekBar.setIndicatorText("配送中")
                }

                if (rangeSeekBar.rangeSeekBarState[0].isMin) {
                    rangeSeekBar.leftSeekBar.setIndicatorText("商家接单")
                } else if (rangeSeekBar.rangeSeekBarState[0].isMax) {
                    rangeSeekBar.leftSeekBar.setIndicatorText("已送达")
                }
            }

            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

            }

        })
    }
}