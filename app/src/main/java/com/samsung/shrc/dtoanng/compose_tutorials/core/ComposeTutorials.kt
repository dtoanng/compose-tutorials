package com.samsung.shrc.dtoanng.compose_tutorials.core

import android.app.Application
import com.samsung.shrc.dtoanng.compose_tutorials.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ComposeTutorials : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}