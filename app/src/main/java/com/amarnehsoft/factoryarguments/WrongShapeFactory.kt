package com.amarnehsoft.factoryarguments

import java.lang.IllegalStateException

object WrongShapeFactory {
    /**
     * @param T type of shape sub-class.
     * @param radius required to construct [Circle] instance.
     * @param width required to construct [Rectangle] instance.
     * @param height required to construct [Rectangle] instance.
     */
    fun <T: Shape> getShape(shape: Class<T>, radius: Int, width: Int, height: Int): Shape {
        if (shape.isAssignableFrom(Circle::class.java)) {
            return Circle(radius)
        } else if (shape.isAssignableFrom(Rectangle::class.java)) {
            return Rectangle(width, height)
        } else {
            throw IllegalStateException("Cannot create shape instance for ${shape.simpleName}")
        }
    }
}