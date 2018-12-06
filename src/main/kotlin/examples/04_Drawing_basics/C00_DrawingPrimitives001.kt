
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.draw.LineJoin
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle

fun main(args: Array<String>) {
    application {
        configure {
        }
        program {
            extend(SingleScreenshot()) {
                outputFile = "media/circle-002.png"
            }
        
            extend {
                drawer.background(ColorRGBa.PINK)
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
    