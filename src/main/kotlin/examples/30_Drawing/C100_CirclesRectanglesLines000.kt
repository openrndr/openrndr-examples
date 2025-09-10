
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.math.Vector2

fun main() {
    application {
        configure {
            height = 300
        }
        program {
            extend {
                drawer.clear(ColorRGBa.PINK)
            
                // -- draw a circle with white fill and black stroke
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0, height / 2.0, width / 8.0)
            
                // -- draw a circle without a fill, but with black stroke
                drawer.fill = null
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0 + width / 3.0, height / 2.0, width / 8.0)
            
                // -- draw a circle with white fill, but without a stroke
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = null
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0 + 2 * width / 3.0, height / 2.0, width / 8.0)
            }
        }
    }
}
    