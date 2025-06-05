package com.kleberson.listadecursos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Db(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTablePerson = "CREATE TABLE IF NOT EXISTS person(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName TEXT NOT NULL, " +
                "lastName TEXT NOT NULL, " +
                "course TEXT NOT NULL, " +
                "contact TEXT NOT NULL" +
                ");"
        db?.execSQL(createTablePerson)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertPerson(firstName: String, lastName: String, course: String, contact: String) {
        val db = writableDatabase
        val sql = "INSERT INTO person (firstName, lastName, course, contact) VALUES (?, ?, ?, ?)"
        db.execSQL(sql, arrayOf(firstName, lastName, course, contact))
        db.close()
    }

}