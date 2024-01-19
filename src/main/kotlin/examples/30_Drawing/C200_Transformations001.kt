
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import kotlin.math.cos

fun main() {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                // move the object to the vertical center of the screen
                drawer.translate(0.0, height / 2.0)
                // set up horizontal translation
                drawer.translate(seconds * 100.0, 0.0)
                // set up vertical translation
                drawer.translate(0.0, cos(seconds * Math.PI * 2.0) * 50.00)
            
                drawer.rectangle(-50.0, -50.0, 100.0, 100.00)
            }
        }
    }
}
    