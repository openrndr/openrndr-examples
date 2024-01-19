
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.font.loadFace
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.shape.LineSegment

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
                    // -- animate the text leading
                    leading = cos(seconds) * 20.0 + 24.0
                    // -- animate the text tracking
                    tracking = sin(seconds) * 20.0 + 24.0
                    box = Rectangle(40.0, 40.0, width - 80.0, height - 80.0)
                    newLine()
                    text("Here is a line of text..")
                    newLine()
                    text("Here is another line of text..")
                    newLine()
                    text("Let's even throw another line of text in, for good measure! yay")
                }
            }
        }
    }
}
    