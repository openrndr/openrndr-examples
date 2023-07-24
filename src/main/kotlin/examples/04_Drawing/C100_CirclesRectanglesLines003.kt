
package examples.`04_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.math.Vector2

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.PINK)
                // -- setup line appearance
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 5.0
                drawer.lineCap = LineCap.ROUND
            
                val points = listOf(Vector2(10.0, height - 10.0), Vector2(width / 2.0, 10.0), Vector2(width - 10.0, height - 10.0))
                drawer.lineStrip(points)
            }
        }
    }
}
    