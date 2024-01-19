
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
            extend {
                // A rotation transformation to apply to the rectangle
                val rotation = transform {
                    translate(width * 0.6, height * 0.5)
                    rotate(seconds * 18)
                }
            
                val circle = Circle(width * 0.4, height * 0.5, 80.0).contour
                val rotatingRect = Rectangle.fromCenter(Vector2.ZERO, 150.0).contour.transform(rotation)
            
                val intersections = circle.intersections(rotatingRect)
            
                drawer.clear(ColorRGBa.WHITE)
                drawer.strokeWeight = 2.0
                drawer.stroke = ColorRGBa.PINK
                drawer.fill = ColorRGBa.PINK.opacify(0.5)
            
                drawer.contour(circle)
                drawer.contour(rotatingRect)
            
                // Draw intersections as small circles
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = ColorRGBa.BLACK.opacify(0.5)
                drawer.circles(intersections.map {
                    it.position
                }, 5.0)
            }
        }
    }
}
    