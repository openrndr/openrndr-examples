
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extra.color.colormatrix.grayscale
import org.openrndr.extra.color.colormatrix.invert
import org.openrndr.extra.color.colormatrix.tint
import org.openrndr.shape.Rectangle

fun main() {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
        
            extend {
                drawer.drawStyle.colorMatrix = invert
                drawer.image(image, 0.0, 0.0)
            }
        }
    }
}
    