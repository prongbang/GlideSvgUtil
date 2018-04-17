package com.prongbang.glidesvgutil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlideSvgUtil(this).builder().load(ivPreviewFromUrl, "https://image.flaticon.com/icons/svg/825/825730.svg")

        GlideSvgUtil(this).builder().load(ivPreviewFromRes, R.raw.flower)

    }
}
