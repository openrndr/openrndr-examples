
package examples.`01_Before_you_start`

import org.openrndr.application
import org.openrndr.color.ColorRGBa

fun main(args: Array<String>) {
    application {
        configure {
            width = 640
            height = 480
        }
        program {
    
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(drawer.bounds.center, Math.abs(Math.cos(seconds)) * 300)
            }
        }
    }
}
    