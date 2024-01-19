
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.Pulley
import org.openrndr.extra.shapes.hobbyCurve
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.math.Vector2
import org.openrndr.math.transforms.transform
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val c = contour {
                moveTo(width * (1.0 / 2.0), height * (1.0 / 5.0))
                curveTo(width * (1.0 / 4.0), height * (2.0 / 5.0), width * (3.0 / 4.0), height * (3.0 / 5.0), width * (2.0 / 4.0), height * (4.0 / 5.0))
            }
            extend {
                drawer.stroke = ColorRGBa.PINK
                drawer.strokeWeight = 2.0
                drawer.lineJoin = LineJoin.ROUND
                drawer.contour(c)
                for (i in -8..8) {
                    val o = c.offset(i * 10.0 * cos(seconds + 0.5))
                    drawer.contour(o)
                }
            }
        }
    }
}
    