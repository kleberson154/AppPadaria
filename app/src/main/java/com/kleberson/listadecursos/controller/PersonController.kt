package com.kleberson.listadecursos.controller

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kleberson.listadecursos.model.Person

class PersonController(private val context: Context) {
    override fun toString(): String {
        Log.d("MVC_controller", "Controller iniciado")
        return super.toString()
    }

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
        Log.d("MVC_controller", "Dados salvos: ${person.toString()}")
    }

    fun limpar(view: View, firstNameInput: EditText, lastNameInput: EditText, nameCourseInput: EditText, contactInput: EditText) {
        firstNameInput.setText("")
        lastNameInput.setText("")
        nameCourseInput.setText("")
        contactInput.setText("")
        clearPreferences()
        Log.d("MVC_controller", "Dados limpos")
    }

    fun finalizar(view: View) {
        Toast.makeText(context, "Volte Sempre", Toast.LENGTH_SHORT).show()
        if (context is AppCompatActivity) {
            context.finish()
        }
        Log.d("MVC_controller", "Programa finalizado")
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
        editor.putString("firstName", person.firstName)
        editor.putString("lastName", person.lastName)
        editor.putString("nameCourse", person.course)
        editor.putString("contact", person.contact)
        editor.apply()
    }


}
