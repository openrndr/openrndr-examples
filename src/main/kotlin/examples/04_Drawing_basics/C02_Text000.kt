
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont

import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val font = loadFont("data/fonts/default.otf", 48.0)
            extend {
                drawer.clear(ColorRGBa.PINK)
                drawer.fontMap = font
                drawer.fill = ColorRGBa.BLACK
                drawer.text("HELLO WORLD", width / 2.0 - 100.0, height / 2.0)
            }
        }
    }
}
    