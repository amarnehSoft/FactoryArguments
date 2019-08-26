package com.amarnehsoft.factoryarguments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var mode: Mode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemId = intent.getStringExtra("itemId")
        mode = if (itemId == null) {
            Mode.AddMode
        } else {
            Mode.EditMode(itemId)
        }


        val circle = WrongShapeFactory.getShape(
                shape = Circle::class.java,
                radius = 10,
                width = 0,
                height = 0
        )

        val square = WrongShapeFactory.getShape(
                shape = Rectangle::class.java,
                width = 10,
                height = 8,
                radius = 0
        )

        val circle2 = GoodShapeFactory.getShape(ShapeFactoryParam.CircleParam(
                10
        ))

        val square2 = GoodShapeFactory.getShape(ShapeFactoryParam.RectangleParam(
                width = 10,
                height = 8
        ))
    }

    companion object {
        sealed class Mode {
            object AddMode : Mode()
            data class EditMode(val itemId: String) : Mode()
        }

        fun newIntent(context: Context, mode: Mode): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return when (mode) {
                is Mode.AddMode -> intent
                is Mode.EditMode -> intent.putExtra("itemId", mode.itemId)
            }
        }
    }
}
