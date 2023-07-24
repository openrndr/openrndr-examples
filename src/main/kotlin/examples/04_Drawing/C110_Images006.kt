
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
        program {
            val image = loadImage("data/images/cheeta.jpg")
        
            extend {
                // -- here we concatenate the transforms using the multiplication operator.
                drawer.drawStyle.colorMatrix = tint(ColorRGBa.PINK) * grayscale()
                drawer.image(image)
            }
        }
    }
}
    