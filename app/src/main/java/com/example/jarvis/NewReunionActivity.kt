package com.example.jarvis

import android.os.Bundle
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NewReunionActivity : AppCompatActivity() {
    lateinit var valChangedDate: String
    override fun onCreate(savedInstanceState: Bundle?) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reunion)
        val reunion_date: CalendarView = findViewById(R.id.date_reunion)
        reunion_date.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            valChangedDate = "" + dayOfMonth + "-" + (month + 1) + "-" + year
        }
        val button_submit = findViewById(R.id.button_submit_reunion) as Button

        button_submit.setOnClickListener {
            val reunion_name: EditText = findViewById(R.id.nom_reunion)
            val name = reunion_name.text
            val reunion_horaire: EditText = findViewById(R.id.horaire_reunion)
            val horaire = reunion_horaire.text
            val reunion_lieu: EditText = findViewById(R.id.lieu_reunion)
            val lieu = reunion_lieu.text

            val reunion_contact: EditText = findViewById(R.id.contact_reunion)
            val contact = reunion_contact.text
            val reunion_phone: EditText = findViewById(R.id.telephone_reunion)
            val phone = reunion_phone.text
            val reunion_type: Spinner = findViewById(R.id.spinner_reunion)
            val type = reunion_type.selectedItem
            println("$name, $horaire ,$lieu, $valChangedDate ,$contact ,$phone ,$type")
        }


    }
}