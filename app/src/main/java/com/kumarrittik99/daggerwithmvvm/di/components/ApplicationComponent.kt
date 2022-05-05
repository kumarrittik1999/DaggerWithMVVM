package com.kumarrittik99.daggerwithmvvm.di.components

import com.kumarrittik99.daggerwithmvvm.di.modules.NetworkModule
import com.kumarrittik99.daggerwithmvvm.features.main.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun injectDependencies(activity: MainActivity)
}