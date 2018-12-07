
package examples.`04_Drawing_basics`

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
                outputFile = "media/04_Drawing_basics-circles-001.png"
            })
            extend {
                drawer.background(ColorRGBa.WHITE)
                // -- setup appearance
                drawer.fill = ColorRGBa.RED
                drawer.stroke = ColorRGBa.BLUE
                drawer.strokeWeight = 1.0
                // -- draw a circle with its center at (140.0, 140.0) with radius 130.0
                drawer.circle(140.0, 140.0, 130.0)
            }
        }
    }
}
    