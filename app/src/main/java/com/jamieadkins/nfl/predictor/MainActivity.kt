package com.jamieadkins.nfl.predictor

import android.os.Bundle
import com.jamieadkins.nfl.predictor.PredictorApplication.Companion.coreComponent
import com.jamieadkins.nfl.predictor.di.DaggerAndroidActivity
import com.jamieadkins.nfl.predictor.di.DaggerAppComponent

class MainActivity : DaggerAndroidActivity() {

    override fun onInject() {
        DaggerAppComponent.builder()
            .core(coreComponent)
            .activity(this)
            .build()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
