package com.kleberson.listadecursos.controller

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kleberson.listadecursos.model.Person

class PersonController(private val context: Context) {
    fun salvar(view: View, firstNameInput: EditText, lastNameInput: EditText, nameCourseInput: EditText, contactInput: EditText) {
        val person = Person(
            firstNameInput.text.toString(),
            lastNameInput.text.toString(),
            nameCourseInput.text.toString(),
            contactInput.text.toString()
        )
        savePreferences(person)

        firstNameInput.setText("")
        lastNameInput.setText("")
        nameCourseInput.setText("")
        contactInput.setText("")

        Toast.makeText(context, "Dados Salvos", Toast.LENGTH_SHORT).show()
    }

    fun limpar(view: View, firstNameInput: EditText, lastNameInput: EditText, nameCourseInput: EditText, contactInput: EditText) {
        firstNameInput.setText("")
        lastNameInput.setText("")
        nameCourseInput.setText("")
        contactInput.setText("")
        clearPreferences()
    }

    fun finalizar(view: View) {
        Toast.makeText(context, "Volte Sempre", Toast.LENGTH_SHORT).show()
        if (context is AppCompatActivity) {
            context.finish()
        }
    }

    private fun clearPreferences() {
        val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun savePreferences(person: Person) {
        val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("firstName", person.getFirstName())
        editor.putString("lastName", person.getLastName())
        editor.putString("nameCourse", person.getCourse())
        editor.putString("contact", person.getContact())
        editor.apply()
    }
}
