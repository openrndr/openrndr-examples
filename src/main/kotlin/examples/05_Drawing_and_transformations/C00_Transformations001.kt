
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
            extend(ScreenRecorder()) {
                multisample = BufferMultisample.SampleCount(8)
                frameRate = 60
                quitAfterMaximum = true
                maximumDuration = 7.7
                outputFile = "media/transformations-002.mp4"
            }
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                // move the object to the vertical center of the screen
                drawer.translate(0.0, height / 2.0)
                // set up horizontal translation
                drawer.translate(seconds * 100.0, 0.0)
                // set up vertical translation
                drawer.translate(0.0, Math.cos(seconds * Math.PI * 2.0) * 50.00)
            
                drawer.rectangle(-50.0, -50.0, 100.0, 100.00)
            }
        }
    }
}
    