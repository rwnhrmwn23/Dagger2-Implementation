package com.onedev.dicoding.dagger2implementation.di

import com.onedev.dicoding.dagger2implementation.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface IRetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)

}