
package examples.drawing

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot

fun main(args: Array<String>) {
    application {
        configure {
            width = 640
            height = 480
        }
        program {
            extend(SingleScreenshot().apply {
                outputFile = "media/drawing-circles-001.png"
            })
            extend {
                drawer.background(ColorRGBa.WHITE)
                drawer.fill = ColorRGBa.RED
                drawer.stroke = ColorRGBa.BLUE
                drawer.strokeWeight = 1.0
                drawer.circle(140.0, 140.0, 130.0)
            }
        }
    }
}
    