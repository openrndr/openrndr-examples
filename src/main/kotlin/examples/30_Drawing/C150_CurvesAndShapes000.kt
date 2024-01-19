
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
        configure {
            height = 200
        }
        program {
            val font = loadFont("data/fonts/default.otf", 16.0)
            val pts = listOf(Vector2(50.0, 55.0), Vector2(100.0, height - 40.0), Vector2(200.0, 35.0), Vector2(280.0, 50.0), Vector2(250.0, height - 40.0), Vector2(500.0, 35.0), Vector2(550.0, height * 0.5), Vector2(400.0, height * 0.6), Vector2(450.0, height - 40.0))
            val off = Vector2(10.0, 0.0)
            val off2 = Vector2(-20.0, 20.0)
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fontMap = font
            
                drawer.stroke = null
                drawer.fill = ColorRGBa.fromHex("#ff7990")
                drawer.circles(pts.subList(0, 2), 4.0)
                drawer.fill = ColorRGBa.fromHex("#70e1e1")
                drawer.circles(pts.subList(2, 5), 4.0)
                drawer.fill = ColorRGBa.fromHex("#ff9b41")
                drawer.circles(pts.subList(5, 9), 4.0)
            
    
                drawer.fill = ColorRGBa.BLACK
                drawer.text("start", pts[0] + off)
                drawer.text("end", pts[1] + off)
                drawer.text("Linear", pts[1] + off2)
            
                drawer.text("start", pts[2] + off)
                drawer.text("control point", pts[3] + off)
                drawer.text("end", pts[4] + off)
                drawer.text("Quadratic", pts[4] + off2)
            
                drawer.text("start", pts[5] + off)
                drawer.text("cp 1", pts[6] + off)
                drawer.text("cp 2", pts[7] + off)
                drawer.text("end", pts[8] + off)
                drawer.text("Cubic", pts[8] + off2)
            
                drawer.stroke = ColorRGBa.BLACK
                drawer.segment(Segment(pts[0], pts[1]))
                drawer.segment(Segment(pts[2], pts[3], pts[4]))
                drawer.segment(Segment(pts[5], pts[6], pts[7], pts[8]))
            }
        }
    }
}
    