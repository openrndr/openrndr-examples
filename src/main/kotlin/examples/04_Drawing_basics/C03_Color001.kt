
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.*
import org.openrndr.extensions.SingleScreenshot

fun main(args: Array<String>) {
    application {
        program {
            extend {
                drawer.stroke = null
                val baseColor = ColorRGBa.PINK
            
                drawer.fill = ColorRGBa.GRAY.shade(0.5)
                drawer.rectangle(35.0, 32.0, 700.0, 64.00)
            
                // -- draw 16 darker shades of pink
                for (i in 0..15) {
                    drawer.fill = baseColor.opacify(i / 15.0)
                    drawer.rectangle(35.0 + (700 / 16.0) * i, 64.0, (700 / 16.0), 64.0)
                }
            }
        }
    }
}
    