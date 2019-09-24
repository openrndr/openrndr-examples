
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.grayscale
import org.openrndr.draw.invert
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extensions.Screenshots
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.shape.Rectangle
import java.io.File

fun main(args: Array<String>) {
    application {
        program {
            val image = loadImage("data/cheeta.jpg")
        
            extend {
                // -- the factors below determine the RGB mixing factors
                drawer.drawStyle.colorMatrix = grayscale(1.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0)
                drawer.image(image)
            }
        }
    }
}
    