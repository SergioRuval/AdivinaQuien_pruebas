package com.example.pruebasproyecto.preguntas

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PreguntasAdapter( private val mContext : Context, private val listaParametros : List<String>)
    : ArrayAdapter<String>(mContext, 0, listaParametros) {

}