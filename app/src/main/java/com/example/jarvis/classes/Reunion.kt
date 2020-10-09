package com.example.jarvis.classes

import android.content.Context
import android.os.Environment
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import org.json.JSONObject
import java.io.*
import java.time.LocalDate
import java.time.LocalTime


data class Reunion (var name: Editable ?,var horaire: LocalTime ?,var lieu: Editable ?,var contact: Editable ?,
                var phone: Editable ?,var type: String ?,var date: LocalDate ?) {

    fun writeOnJson(context: Context) {
        val dir = context.getExternalFilesDir("/reunion")
        val nFile = File(dir, "reunion.json")
        val writer = FileWriter(nFile)
        var json = JSONObject()
        json.put("Reunion",addReunion(this))
        writer.append(json.toString())
        writer.flush()
        writer.close()
        println(nFile?.readText())
    }

    fun addReunion(reunion: Reunion): JSONObject {
        return JSONObject()
            .put("name",reunion.name)
            .put("horaire",reunion.horaire)
            .put("lieu",reunion.lieu)
            .put("contact",reunion.contact)
            .put("phone",reunion.phone)
            .put("type",reunion.type)
            .put("date",reunion.date)
    }

    fun getAllReunions(context: Context) {
        val json = JSONObject()
        val gson = Gson()
        val reunionList = gson.fromJson(File(context.getExternalFilesDir("/reunion"), "reunion.json")?.readText(), Array<Reunion>::class.java)
    }

}





/**TODO : Création d'un fichier ressource en XML pour stocker les réunions
 * TODO : Création des méthodes pour lire et écrire dans le fichier
 * TODO : Création de l'onglet calendrier qui recensera toutes les réunions présentes dans le fichier
 * TODO : Mise en place des émojis/couleur par rapport au type de réunion
 */