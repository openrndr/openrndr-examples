
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
            val c = Pulley(Circle(Vector2.ZERO, 30.0), Circle(Vector2.ONE * 120.0, 60.0)).contour
            val cr = c.rectified()
        
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
            
                // Go from 0.0 to 1.0 in two seconds
                // slowing down at both ends
                val t = cos(kotlin.math.PI * (seconds % 2.0) / 2.0) * 0.5 + 0.5
            
                drawer.translate(150.0, 100.0)
                drawer.contour(c)
                // Note how segment length affects the speed
                drawer.circle(c.position(t), 5.0)
            
                drawer.translate(270.0, 0.0)
                drawer.contour(c)
                // The rectified contour provides a smooth animation
                drawer.circle(cr.position(t), 5.0)
            }
        }
    }
}
    