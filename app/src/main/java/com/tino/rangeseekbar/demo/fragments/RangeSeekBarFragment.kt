package com.tino.rangeseekbar.demo.fragments

import android.view.View
import com.tino.rangeseekbar.SeekBar
import com.tino.rangeseekbar.demo.R
import kotlinx.android.synthetic.main.fragment_range.*

class RangeSeekBarFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_range
    }

    override fun initView(view: View) {
        sb_range_3?.setRange(-1000f, 1000f, 1f)
        sb_range_3?.setProgress(-300f, 300f)
        sb_range_3?.setIndicatorTextDecimalFormat("0")
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