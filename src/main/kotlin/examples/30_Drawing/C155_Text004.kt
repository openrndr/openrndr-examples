
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.font.loadFace
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.extra.textwriter.writer
import org.openrndr.shape.LineSegment
import org.openrndr.shape.Rectangle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val face = loadFace("data/fonts/default.otf")
            val shape = face.glyphForCharacter(character = '8').shape(scale = 1.0)
        
            extend {
                drawer.clear(ColorRGBa.WHITE)
                // Center the shape on the screen
                drawer.translate(drawer.bounds.center - shape.bounds.center)
            
                drawer.fill = null
                drawer.strokeWeight = 2.0
            
                // Draw each contour found in the character '8' with a different color
                shape.contours.forEachIndexed { i, it ->
                    drawer.stroke = listOf(ColorRGBa.PINK, rgb(0.33), rgb(0.66))[i]
                    drawer.contour(it)
                }
            }
        }
    }
}
    