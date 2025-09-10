
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
    