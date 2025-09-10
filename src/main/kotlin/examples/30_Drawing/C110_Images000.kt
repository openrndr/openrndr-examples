
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
        configure {}
        program {
            val image = loadImage("data/images/cheeta.jpg")
        
            extend {
                drawer.image(image)
            }
        }
    }
}
    