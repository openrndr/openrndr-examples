
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.*

fun main() {
    application {
        program {
            extend {
                drawer.stroke = null
                val leftColor = ColorRGBa.PINK
                val rightColor = ColorRGBa.fromHex(0xFC3549)
            
                // -- draw 16 color mixes
                for (i in 0..15) {
                    drawer.fill = mix(leftColor, rightColor, i / 15.0)
                    drawer.rectangle(35.0 + (700 / 16.0) * i, 32.0, (700 / 16.0), 64.0)
                }
            }
        }
    }
}
    