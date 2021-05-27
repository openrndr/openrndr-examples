
package examples.`05_Drawing_and_transformations`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.BufferMultisample
import org.openrndr.ffmpeg.ScreenRecorder

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
            
                // -- translate
                drawer.translate(width / 2.0, height / 2.0)
                // -- rotate
                drawer.rotate(seconds * 10.0)
                // -- rectangle around the origin
                drawer.rectangle(-50.0, -50.0, 100.0, 100.0)
            }
        }
    }
}
    