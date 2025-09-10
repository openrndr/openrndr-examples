
package examples.`30_Drawing`

import offset.offset
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.hobbycurve.hobbyCurve
import org.openrndr.extra.shapes.primitives.Pulley
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.math.Vector2
import org.openrndr.math.transforms.transform
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
            
                val point = Circle(185.0, height / 2.0, 90.0).contour.position((seconds * 0.1) % 1.0)
                drawer.circle(point, 10.0)
            
                val points0 = Circle(385.0, height / 2.0, 90.0).contour.equidistantPositions(20)
                drawer.circles(points0, 10.0)
            
                val points1 = Circle(585.0, height / 2.0, 90.0).contour.equidistantPositions((cos(seconds) * 10.0 + 30.0).toInt())
                drawer.circles(points1, 10.0)
            }
        }
    }
}
    