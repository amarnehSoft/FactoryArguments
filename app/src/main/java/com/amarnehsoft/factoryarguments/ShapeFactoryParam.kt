package com.amarnehsoft.factoryarguments

sealed class ShapeFactoryParam {
    data class CircleParam(val radius: Int) : ShapeFactoryParam()
    data class RectangleParam(val width: Int, val height: Int): ShapeFactoryParam()
}