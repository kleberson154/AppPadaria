package com.kleberson.listadecursos.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kleberson.listadecursos.R
import com.kleberson.listadecursos.controller.PersonController

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

    fun salvar(view: View) {
        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val nameCourseInput = findViewById<EditText>(R.id.nameCourseInput)
        val contactInput = findViewById<EditText>(R.id.contactInput)

        val personController = PersonController(this)
        personController.salvar(view, firstNameInput, lastNameInput, nameCourseInput, contactInput)
    }

    fun limpar(view: View) {
        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val nameCourseInput = findViewById<EditText>(R.id.nameCourseInput)
        val contactInput = findViewById<EditText>(R.id.contactInput)

        val personController = PersonController(this)
        personController.limpar(view, firstNameInput, lastNameInput, nameCourseInput, contactInput)
    }

    fun finalizar(view: View) {
        val personController = PersonController(this)
        personController.finalizar(view)
    }
}