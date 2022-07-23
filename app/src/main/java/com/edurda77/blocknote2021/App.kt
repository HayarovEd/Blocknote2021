package com.edurda77.blocknote2021

import android.app.Application
import android.content.Context
import com.edurda77.blocknote2021.di.mainViewModelModule
import com.edurda77.blocknote2021.di.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    mainViewModelModule,
                    roomModule
                )
            )
        }
    }

}