package com.tino.rangeseekbar.demo.fragments

import android.view.View
import com.tino.rangeseekbar.demo.R
import kotlinx.android.synthetic.main.fragment_step.*
import java.util.*

class StepsSeekBarFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_step
    }

    override fun initView(view: View) {
        val stepsDrawables = ArrayList<Int>()
        stepsDrawables.add(R.drawable.step_1)
        stepsDrawables.add(R.drawable.step_2)
        stepsDrawables.add(R.drawable.step_3)
        stepsDrawables.add(R.drawable.step_4)
        sb_steps_1?.setStepsDrawable(stepsDrawables)
        sb_steps_2?.setStepsDrawable(stepsDrawables)
    }
}