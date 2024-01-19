
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
            // -- create a contour from Rectangle object
            val c = Rectangle(100.0, 100.0, width - 200.0, height - 200.0).contour.reversed
        
            extend {
                drawer.fill = null
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(c)
                for (i in 1 until 10) {
                    val o = c.offset(cos(seconds + 0.5) * i * 10.0, SegmentJoin.BEVEL)
                    drawer.contour(o)
                }
            }
        }
    }
}
    