
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = null
                drawer.stroke = ColorRGBa.PINK
                drawer.strokeWeight = 4.0
            
                val sub0 = Circle(185.0, height / 2.0, 100.0).contour.sub(0.0, 0.5 + 0.50 * sin(seconds))
                drawer.contour(sub0)
            
                val sub1 = Circle(385.0, height / 2.0, 100.0).contour.sub(seconds * 0.1, seconds * 0.1 + 0.1)
                drawer.contour(sub1)
            
                val sub2 = Circle(585.0, height / 2.0, 100.0).contour.sub(-seconds * 0.05, seconds * 0.05 + 0.1)
                drawer.contour(sub2)
            }
        }
    }
}
    