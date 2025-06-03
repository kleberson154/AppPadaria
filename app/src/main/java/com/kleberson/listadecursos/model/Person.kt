package com.kleberson.listadecursos.model

class Person {
    var firstName: String = ""
    var  lastName: String = ""
    var  course: String = ""
    var  contact: String = ""

    class Person(var firstName: String, var lastName: String, var course: String, var contact: String) {

    }

    override fun toString(): String {
        return "Usuario Salvo: $firstName $lastName, Curso: $course, Contato: $contact"
    }


}
