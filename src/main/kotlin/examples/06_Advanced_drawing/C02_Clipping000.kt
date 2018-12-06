
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.shape.Rectangle

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend(ScreenRecorder()) {
                outputFile = "media/clipping-001.mp4"
                quitAfterMaximum = true
                maximumDuration = 10.0
                frameRate = 60
            }
            extend {
                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
            
                // -- set the rectangular clipping mask
                drawer.drawStyle.clip = Rectangle(100.0, 100.0, width - 200.0, height - 200.00)
            
                drawer.circle(Math.cos(seconds) * width / 2.0 + width / 2.0, Math.sin(seconds) * height / 2.0 + height / 2.0, 200.0)
            
                // -- restore clipping
                drawer.drawStyle.clip = null
            }
        }
    }
}
    