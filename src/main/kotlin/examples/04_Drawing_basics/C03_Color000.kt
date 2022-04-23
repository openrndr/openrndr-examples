
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.*

fun main() {
    application {
        program {
            extend {
                drawer.stroke = null
                val baseColor = ColorRGBa.PINK
                // -- draw 16 darker shades of pink
                for (i in 0..15) {
                    drawer.fill = baseColor.shade(i / 15.0)
                    drawer.rectangle(35.0 + (700 / 16.0) * i, 32.0, (700 / 16.0), 64.0)
                }
                // -- draw 16 lighter shades of pink
                for (i in 0..15) {
                    drawer.fill = baseColor.shade(1.0 + i / 15.0)
                    drawer.rectangle(35.0 + (700 / 16.0) * i, 96.0, (700 / 16.0), 64.0)
                }
            }
        }
    }
}
    