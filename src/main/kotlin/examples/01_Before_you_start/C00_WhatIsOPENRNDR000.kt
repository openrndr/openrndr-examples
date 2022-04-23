
package examples.`01_Before_you_start`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import kotlin.math.abs
import kotlin.math.cos

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(drawer.bounds.center, abs(cos(seconds)) * height * 0.5)
            }
        }
    }
}
    