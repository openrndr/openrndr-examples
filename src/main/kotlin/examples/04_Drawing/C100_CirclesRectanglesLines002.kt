
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
            
                drawer.lineSegment(10.0, height / 2.0 - 20.0, width - 10.0, height / 2.0 - 20.0)
            
                drawer.lineCap = LineCap.BUTT
                drawer.lineSegment(10.0, height / 2.0, width - 10.0, height / 2.0)
            
                drawer.lineCap = LineCap.SQUARE
                drawer.lineSegment(10.0, height / 2.0 + 20.0, width - 10.0, height / 2.0 + 20.0)
            }
        }
    }
}
    