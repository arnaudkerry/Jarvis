package com.example.jarvis

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class NewReunionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reunion)
    }
}