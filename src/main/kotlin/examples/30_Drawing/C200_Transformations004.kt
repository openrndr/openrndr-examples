
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
            
                // -- translate to the screen center
                drawer.translate(width / 2.0, height / 2.0)
            
                drawer.rotate(20.00 + seconds * 60.0)
                // -- rectangle around the origin
                drawer.rectangle(-50.0, -50.0, 100.0, 100.0)
            
                // -- draw a second rectangle, sharing the rotation of the first rectangle but with an offset
                drawer.translate(150.0, 0.0)
                drawer.rectangle(-50.0, -50.0, 100.0, 100.0)
            }
        }
    }
}
    