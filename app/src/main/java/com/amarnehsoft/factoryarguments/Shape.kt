package com.amarnehsoft.factoryarguments

interface Shape {
    fun draw()
}

class Circle(private val radius: Int): Shape {
    override fun draw() {
        //TODO("draw circel with radius")
    }
}

class Rectangle(private val width: Int, private val height: Int) : Shape {
    override fun draw() {
        //TODO("Draw Rectangle with width and height")
    }
}