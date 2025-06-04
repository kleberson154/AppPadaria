package com.kleberson.listadecursos.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kleberson.listadecursos.R
import com.kleberson.listadecursos.model.Person

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun salvar(view: View){
        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val nameCourseInput = findViewById<EditText>(R.id.nameCourseInput)
        val contactInput = findViewById<EditText>(R.id.contactInput)
        val person = Person(firstNameInput.text.toString(),
            lastNameInput.text.toString(),
            nameCourseInput.text.toString(),
            contactInput.text.toString())
        savePreferences(person)

        firstNameInput.setText("")
        lastNameInput.setText("")
        nameCourseInput.setText("")
        contactInput.setText("")

        Toast.makeText(this, "Dados Salvos", Toast.LENGTH_SHORT).show()
    }

    fun limpar(view: View){
        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val nameCourseInput = findViewById<EditText>(R.id.nameCourseInput)
        val contactInput = findViewById<EditText>(R.id.contactInput)

        firstNameInput.setText("")
        lastNameInput.setText("")
        nameCourseInput.setText("")
        contactInput.setText("")
        clearPreferences()
    }

    fun finalizar(view: View) {
        Toast.makeText(this, "Volte Sempre", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun savePreferences(person: Person) {
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("firstName", person.firstName.toString())
        editor.putString("lastName", person.lastName.toString())
        editor.putString("nameCourse", person.course.toString())
        editor.putString("contact", person.contact.toString())
        editor.apply()
    }

    fun clearPreferences() {
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

}