package com.example.pruebasproyecto.preguntas

import java.io.Serializable

class Categoria (nombre : String, preguntas : List<String>, existe : Boolean) : Serializable {
    val nombre : String = nombre
    val preguntas : List<String> = preguntas
    val totalPreguntas = preguntas.size
    val existe : Boolean = existe
}