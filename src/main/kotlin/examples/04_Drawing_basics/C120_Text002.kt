
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
        configure {
            width = 770
            height = 578
        }
        program {
            val font = loadFont("data/fonts/default.otf", 24.0)
            extend {
                drawer.clear(ColorRGBa.PINK)
                drawer.fontMap = font
                drawer.fill = ColorRGBa.BLACK
            
                writer {
                    box = Rectangle(40.0, 40.0, 300.0, 300.0)
                    newLine()
                    text("Here is a line of text..")
                    newLine()
                    text("Here is another line of text..")
                }
            }
        }
    }
}
    