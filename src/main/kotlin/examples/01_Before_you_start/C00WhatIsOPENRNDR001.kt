
package examples.`01_Before_you_start`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.ffmpeg.ScreenRecorder

fun main(args: Array<String>) {
    application {
        program {
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(drawer.bounds.center, Math.abs(Math.cos(seconds)) * height * 0.5)
            }
        }
    }
}
    