package com.vivekchoudhary.daggerapp

import android.app.Application
import com.vivekchoudhary.daggerapp.di.DaggerApplicationComponent

class MyApplication : Application() {

    override fun onCreate() {
        DaggerApplicationComponent.create().inject(this)
        super.onCreate()

    }

}