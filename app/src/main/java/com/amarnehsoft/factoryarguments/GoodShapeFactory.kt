package com.amarnehsoft.factoryarguments

object GoodShapeFactory {
    fun getShape(param: ShapeFactoryParam): Shape {
        return when (param) {
            is ShapeFactoryParam.CircleParam -> Circle(param.radius)
            is ShapeFactoryParam.RectangleParam -> Rectangle(param.width, param.height)
        }
    }
}