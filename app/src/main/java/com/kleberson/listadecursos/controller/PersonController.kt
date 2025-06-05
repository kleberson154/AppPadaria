package com.kleberson.listadecursos.controller

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kleberson.listadecursos.model.Person

class PersonController(private val context: Context) {
    override fun toString(): String {
        Log.d("MVC_controller", "Controller iniciado")
        return super.toString()
    }

    fun salvar(firstNameInput: EditText, lastNameInput: EditText, courseSpinner: Spinner, contactInput: EditText) {
        val person = Person(
            firstNameInput.text.toString(),
            lastNameInput.text.toString(),
            courseSpinner.selectedItem.toString(),
            contactInput.text.toString()
        )
        savePreferences(person)

        firstNameInput.setText("")
        lastNameInput.setText("")
        courseSpinner.setSelection(0)
        contactInput.setText("")

        Toast.makeText(context, "Dados Salvos", Toast.LENGTH_SHORT).show()
        Log.d("MVC_controller", "Dados salvos: ${person.toString()}")
    }

    fun limpar(firstNameInput: EditText, lastNameInput: EditText, courseSpinner: Spinner, contactInput: EditText) {
        firstNameInput.setText("")
        lastNameInput.setText("")
        courseSpinner.setSelection(0)
        contactInput.setText("")
        clearPreferences()
        Log.d("MVC_controller", "Dados limpos")
    }

    fun finalizar() {
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

    fun getPreferences(): Person {
        val sharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
        return Person(
            sharedPreferences.getString("firstName", "") ?: "",
            sharedPreferences.getString("lastName", "") ?: "",
            sharedPreferences.getString("nameCourse", "") ?: "",
            sharedPreferences.getString("contact", "") ?: ""
        )
    }
}
