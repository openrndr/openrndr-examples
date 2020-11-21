
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin
import java.lang.Math.toRadians

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                val drawingCenter = Vector2(width * 0.5, height * 0.5)
                val cross = drawComposition {
                    fill = ColorRGBa.PINK
                    stroke = null

                    val flower = (0 until 360 step 45).map { degrees ->
                        val center1 = drawingCenter +
                                Vector2(cos(toRadians(degrees.toDouble())), sin(toRadians(degrees.toDouble()))) * 70.0
                        val center2 = drawingCenter +
                                Vector2(cos(toRadians(degrees - 45.0)), sin(toRadians(degrees - 45.0))) * 70.0
                        intersection(
                                Circle(center1, 65.0).shape,
                                Circle(center2, 65.0).shape
                        )
                    }
                    shapes(flower)
                }

                drawer.composition(cross)
            }
        }
    }
}
    