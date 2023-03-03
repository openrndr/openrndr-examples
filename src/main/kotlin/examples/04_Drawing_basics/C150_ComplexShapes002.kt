
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
        program {
            val points = List(30) {
                Vector2(20.0 + it * 20.0, 300.0 + sin(it * 0.8) * 100.0)
            }
            val wavyContour = ShapeContour.fromPoints(points, closed = true)
        
            val segments = listOf(Segment(Vector2(10.0, 100.0), Vector2(200.0, 80.0)), // Linear Segment
            Segment(Vector2(200.0, 80.0), Vector2(250.0, 280.0), Vector2(400.0, 80.0)), // Quadratic Bézier segment
            Segment(Vector2(400.0, 80.0), Vector2(450.0, 180.0), Vector2(500.0, 0.0), Vector2(630.0, 80.0))) // Cubic Bézier segment
            val horizontalContour = ShapeContour.fromSegments(segments, closed = false)
        
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.contour(wavyContour)
            
                drawer.strokeWeight = 5.0
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(horizontalContour)
            }
        }
    }
}
    