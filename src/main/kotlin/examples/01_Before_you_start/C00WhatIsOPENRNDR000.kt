
package examples.`01_Before_you_start`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.ffmpeg.ScreenRecorder

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 568
        }
        program {
            extend(ScreenRecorder()) {
                outputFile = "media/what-is-001.mp4"
                maximumDuration = 10.0
                quitAfterMaximum = true
            }
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(drawer.bounds.center, Math.abs(Math.cos(seconds)) * height * 0.5)
            }
        }
    }
}
    