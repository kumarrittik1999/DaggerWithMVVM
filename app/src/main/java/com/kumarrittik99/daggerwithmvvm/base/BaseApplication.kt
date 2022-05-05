package com.kumarrittik99.daggerwithmvvm.base

import android.app.Application
import com.kumarrittik99.daggerwithmvvm.di.components.ApplicationComponent
import com.kumarrittik99.daggerwithmvvm.di.components.DaggerApplicationComponent

class BaseApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}