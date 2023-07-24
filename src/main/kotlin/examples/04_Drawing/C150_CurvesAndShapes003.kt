
package examples.`04_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.hobbyCurve
import org.openrndr.math.Vector2
import org.openrndr.math.transforms.transform
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val points = List(20) {
                Vector2(20.0 + it * 32.0, 100.0 + sin(it * 1.0) * it * 3)
            }
            val wavyContour = ShapeContour.fromPoints(points, closed = false)
            val smoothContour = hobbyCurve(points, closed = false)
        
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.strokeWeight = 5.0
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(wavyContour)
            
                drawer.translate(0.0, 10.0) // displace 10px down
                drawer.stroke = ColorRGBa.BLACK.opacify(0.5)
                drawer.contour(smoothContour)
            }
        }
    }
}
    