
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
                outputFile = "media/transformations-004.mp4"
            }
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
            
                // -- translate to center of screen
                drawer.translate(width / 2.0, height / 2.0)
                // -- scale around origin
                drawer.scale(Math.cos(seconds * Math.PI * 2.0) + 2.0)
                // -- rectangle around the origin
                drawer.rectangle(-50.0, -50.0, 100.0, 100.00)
            }
        }
    }
}
    