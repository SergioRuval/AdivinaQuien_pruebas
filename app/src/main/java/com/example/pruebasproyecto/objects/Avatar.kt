package com.example.pruebasproyecto.objects

class Avatar {
    private var nombre : String
    private var atributos : Atributos
    private var imgSource : Int

    constructor(nombre : String, atributos : Atributos, imgSource : Int){
        this.nombre = nombre
        this.atributos  = atributos
        this.imgSource = imgSource
    }

    fun getImgSource() = imgSource

    // TODO - Hacer un método para comparar si existe la característica
    // TODO - Crear una clase de datos para contener las constantes de los nombres de la característica y valores de color
    // TODO - Crear una clase de datos con cada uno de los datos de los personajes apoyándome del archivo que cree Dani
}