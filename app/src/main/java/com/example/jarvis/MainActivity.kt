package com.example.jarvis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation_view = findViewById(R.id.navigation_view) as View
        val new_button = findViewById(R.id.newThing) as ImageView
        val new_commande = findViewById(R.id.new_commande) as TextView
        val new_reunion = findViewById(R.id.new_reunion) as TextView
        val accueil = findViewById(R.id.accueil) as View
        jarvis_view.setOnTouchListener(object: OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeRight() {
                navigation_view.visibility = View.VISIBLE
            }

            override fun onSwipeLeft() {
                navigation_view.visibility = View.INVISIBLE
            }
        })
        new_button.setOnClickListener {
            new_commande.visibility = View.VISIBLE
            new_reunion.visibility = View.VISIBLE
        }

        new_reunion.setOnClickListener {
            startActivity(Intent(this,NewReunionActivity::class.java))
        }

        accueil.setOnClickListener {
            if (new_commande.visibility == View.VISIBLE) {
                new_commande.visibility = View.INVISIBLE
                new_reunion.visibility = View.INVISIBLE
            }

            if(navigation_view.visibility == View.VISIBLE) navigation_view.visibility = View.INVISIBLE
        }


    }


}