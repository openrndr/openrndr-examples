
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
            val segments = listOf(Segment2D(Vector2(10.0, 100.0), Vector2(200.0, 80.0)), // Linear Bézier Segment
            Segment2D(Vector2(200.0, 80.0), Vector2(250.0, 280.0), Vector2(400.0, 80.0)), // Quadratic Bézier segment
            Segment2D(Vector2(400.0, 80.0), Vector2(450.0, 180.0), Vector2(500.0, 0.0), Vector2(630.0, 80.0))) // Cubic Bézier segment
            val horizontalContour = ShapeContour.fromSegments(segments, closed = false)
        
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.strokeWeight = 5.0
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(horizontalContour)
            }
        }
    }
}
    