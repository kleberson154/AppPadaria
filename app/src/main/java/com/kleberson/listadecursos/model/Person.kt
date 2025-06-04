package com.kleberson.listadecursos.model

class Person (private val firstName: String,private val lastName: String, private val course: String, private val contact: String) {
    fun getFirstName() = firstName
    fun getLastName() = lastName
    fun getCourse() = course
    fun getContact() = contact

    override fun toString(): String {
        return "Usuario Salvo: $firstName $lastName, Curso: $course, Contato: $contact"
    }
}
