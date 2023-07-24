
package examples.`04_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.grayscale
import org.openrndr.draw.invert
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
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
    