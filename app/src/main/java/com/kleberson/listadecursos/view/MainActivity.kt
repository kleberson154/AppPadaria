package com.kleberson.listadecursos.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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

        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val nameCourseInput = findViewById<EditText>(R.id.nameCourseInput)
        val contactInput = findViewById<EditText>(R.id.contactInput)
        val buttonSalvar = findViewById<Button>(R.id.button_Salvar)
        val buttonLimpar = findViewById<Button>(R.id.button_Limpar)
        val buttonFinalizar = findViewById<Button>(R.id.button_Finalizar)

        buttonSalvar.setOnClickListener(View.OnClickListener { view ->
            val personController = PersonController(this)
            personController.toString()
            personController.salvar(view, firstNameInput, lastNameInput, nameCourseInput, contactInput)
        })

        buttonLimpar.setOnClickListener(View.OnClickListener { view ->
            val personController = PersonController(this)
            personController.toString()
            personController.limpar(view, firstNameInput, lastNameInput, nameCourseInput, contactInput)
        })

        buttonFinalizar.setOnClickListener(View.OnClickListener { view ->
            val personController = PersonController(this)
            personController.toString()
            personController.finalizar(view)
        })
    }
}
