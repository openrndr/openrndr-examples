
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.draw.LineJoin
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle

fun main(args: Array<String>) {
    application {
        configure {
        }
        program {
        
            extend {
        
                drawer.clear(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0, height / 2.0, width / 8.0)
            
                // -- draw circle without fill, but with black stroke
                drawer.fill = null
                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0 + width / 3.0, height / 2.0, width / 8.0)
            
                // -- draw circle with white fill, but without stroke
                drawer.fill = ColorRGBa.WHITE
                drawer.stroke = null
                drawer.strokeWeight = 1.0
                drawer.circle(width / 6.0 + 2 * width / 3.0, height / 2.0, width / 8.0)
            }
        }
    }
}
    