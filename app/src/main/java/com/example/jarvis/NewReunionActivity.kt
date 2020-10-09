package com.example.jarvis

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.jarvis.classes.Reunion
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class NewReunionActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    var valChangedDate: String = LocalDate.now().toString()
    lateinit var reunion: Reunion
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reunion)
        val reunion_date: CalendarView = findViewById(R.id.date_reunion)
        reunion_date?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.

            if(month < 9) valChangedDate = "" + year + "-0" + (month + 1) + "-" + dayOfMonth
            else valChangedDate = "" + year + "-" + (month + 1) + "-" + dayOfMonth
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
            val type = reunion_type.selectedItem.toString()


            var date = LocalDate.parse(valChangedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRANCE))
            var heure = LocalTime.parse(horaire, DateTimeFormatter.ofPattern("HH:mm", Locale.FRANCE))
            reunion = Reunion(name,heure,lieu,contact,phone,type,date)
            reunion.writeOnJson(this)
        }
        //TODO : Exception sur les élèments non remplies de la réunion (gestion de l'exception par un toast (?)


    }
}