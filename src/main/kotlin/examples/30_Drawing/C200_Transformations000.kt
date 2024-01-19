
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import kotlin.math.cos

fun main() {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                // set up translation
                drawer.translate(seconds * 100.0, height / 2.0)
                drawer.rectangle(-50.0, -50.0, 100.0, 100.0)
            }
        }
    }
}
    