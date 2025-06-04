package com.kleberson.listadecursos.model

class Person (val firstName: String,val lastName: String, val course: String, val contact: String) {
    override fun toString(): String {
        return "Usuario Salvo: $firstName $lastName, Curso: $course, Contato: $contact"
    }
}
