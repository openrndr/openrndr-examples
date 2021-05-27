
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
                val areas = (0..10).flatMap { y ->
                    (0..10).map { x ->
                        val source = Rectangle(x * (width / 10.0), y * (height / 10.0), width / 5.0, height / 5.0)
                        val target = Rectangle(x * (width / 10.0), y * (height / 10.0), width / 10.0, height / 10.0)
                        source to target
                    }
                }
                drawer.image(image, areas)
            }
        }
    }
}
    