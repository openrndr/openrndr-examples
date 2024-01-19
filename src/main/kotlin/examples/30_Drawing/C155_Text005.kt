
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.font.loadFace
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.shape.LineSegment

import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val face = loadFace("data/fonts/default.otf")
            val shape = face.glyphForCharacter('8').shape(750.0)
        
            // Map each contour in the shape to a list of LineSegment,
            // then combine the resulting lists by calling `.flatten()`.
            val normals = shape.contours.map { c ->
                // Work with rectified contours so `t` values are evenly spaced.
                val rc = c.rectified()
                val stepCount = (c.length / 10).toInt()
                List(stepCount) {
                    val t = it / stepCount.toDouble()
                    LineSegment(rc.position(t) + rc.normal(t) * 5.0, rc.position(t) + rc.normal(t) * 20.0)
                }
            }.flatten()
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.translate(drawer.bounds.center - shape.bounds.center)
            
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.shape(shape)
            
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 2.0
                drawer.lineSegments(normals)
            }
        }
    }
}
    