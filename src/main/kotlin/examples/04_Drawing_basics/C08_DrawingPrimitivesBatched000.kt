
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.circleBatch
import org.openrndr.draw.rectangleBatch
import org.openrndr.shape.Circle
import org.openrndr.extra.noise.Random
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
            
                val circles = List(50000) {
                    Circle(Math.random() * width, Math.random() * height, Math.random() * 10.0 + 10.0)
                }
                drawer.circles(circles)
            }
        }
    }
}
    