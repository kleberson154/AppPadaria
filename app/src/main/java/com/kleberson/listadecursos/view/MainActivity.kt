package com.kleberson.listadecursos.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kleberson.listadecursos.R
import com.kleberson.listadecursos.controller.PersonController

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val courses = arrayOf("Selecione o curso", "Android", "Java", "Python", "JavaScript", "C++")

        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val courseSpinner = findViewById<Spinner>(R.id.spinnerCurso)
        val contactInput = findViewById<EditText>(R.id.contactInput)
        val buttonSalvar = findViewById<Button>(R.id.button_Salvar)
        val buttonLimpar = findViewById<Button>(R.id.button_Limpar)
        val buttonFinalizar = findViewById<Button>(R.id.button_Finalizar)
        val personController = PersonController(this)

        courseSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        val person = personController.getPreferences()

        firstNameInput.setText(person.firstName)
        lastNameInput.setText(person.lastName)
        courseSpinner.setSelection(courses.indexOf(person.course))
        contactInput.setText(person.contact)

        buttonSalvar.setOnClickListener {
            personController.toString()
            personController.salvar(firstNameInput, lastNameInput, courseSpinner, contactInput)
        }

        buttonLimpar.setOnClickListener {
            personController.toString()
            personController.limpar(firstNameInput, lastNameInput, courseSpinner, contactInput)
        }

        buttonFinalizar.setOnClickListener {
            personController.toString()
            personController.finalizar()
        }
    }
}
