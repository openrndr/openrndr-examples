
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
        configure {
            height = 160
        }
        program {
            val font = loadFont("data/fonts/default.otf", 16.0)
            val contours = listOf(Circle(100.0, height / 2.0, 50.0).contour, Rectangle.fromCenter(Vector2(280.0, height / 2.0), 100.0).contour, hobbyCurve(listOf(Vector2(400.0, 50.0), Vector2(450.0, 120.0), Vector2(500.0, 80.0), Vector2(600.0, 130.0), Vector2(550.0, 80.0))))
        
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fontMap = font
            
                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
                drawer.circles(contours.map { c ->
                    c.segments.map { seg ->
                        seg.start
                    } + c.position(1.0)
                }.flatten(), 5.0)
            
                drawer.fill = null
                drawer.stroke = ColorRGBa.BLACK
                drawer.contours(contours)
            }
        }
    }
}
    