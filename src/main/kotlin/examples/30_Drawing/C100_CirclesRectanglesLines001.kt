
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
            
                // -- draw rectangle with white fill and black stroke
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.rectangle(width / 6.0 - width / 8.0, height / 2.0 - width / 8.0, width / 4.0, width / 4.0)
            
                // -- draw rectangle without fill, but with black stroke
                drawer.fill = null
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.rectangle(width / 6.0 - width / 8.0 + width / 3.0, height / 2.0 - width / 8.0, width / 4.0, width / 4.0)
            
                // -- draw a rectangle with white fill, but without stroke
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = null
                drawer.strokeWeight = 1.0
                drawer.rectangle(width / 6.0 - width / 8.0 + 2.0 * width / 3.0, height / 2.0 - width / 8.0, width / 4.0, width / 4.0)
            }
        }
    }
}
    