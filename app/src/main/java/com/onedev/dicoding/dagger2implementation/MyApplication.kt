package com.onedev.dicoding.dagger2implementation

import android.app.Application
import com.onedev.dicoding.dagger2implementation.di.DaggerIRetroComponent
import com.onedev.dicoding.dagger2implementation.di.IRetroComponent
import com.onedev.dicoding.dagger2implementation.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: IRetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent  = DaggerIRetroComponent.builder()
            .retroModule(RetroModule())
            .build()

    }

    fun getRetroComponent(): IRetroComponent {
        return retroComponent
    }
}