
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.shape.Rectangle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            extend {
                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
            
                // -- set the rectangular clipping mask
                drawer.drawStyle.clip = Rectangle(100.0, 100.0, width - 200.0, height - 200.00)
            
                drawer.circle(cos(seconds) * width / 2.0 + width / 2.0, sin(seconds) * height / 2.0 + height / 2.0, 200.0)
            
                // -- restore clipping
                drawer.drawStyle.clip = null
            }
        }
    }
}
    