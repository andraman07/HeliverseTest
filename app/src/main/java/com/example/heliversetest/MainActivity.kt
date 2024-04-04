package com.example.heliversetest

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun attachBaseContext(baseContext: Context) {
        val newContext: Context
        val displayMetrics = baseContext.resources.displayMetrics
        val configuration: Configuration = baseContext.resources.configuration
        if (displayMetrics.densityDpi != DisplayMetrics.DENSITY_DEVICE_STABLE) {
            // Current density is different from Default Density. Override it
            configuration.densityDpi = DisplayMetrics.DENSITY_DEVICE_STABLE
            newContext = baseContext.createConfigurationContext(configuration)
        } else {
            // Same density. Just use same context
            newContext = baseContext
        }
        configuration.fontScale = 1.0f
        applyOverrideConfiguration(configuration)
        super.attachBaseContext(newContext)
    }

}