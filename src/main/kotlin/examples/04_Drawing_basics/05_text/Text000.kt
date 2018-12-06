
package examples.`04_Drawing_basics`.`05_text`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle
import org.openrndr.text.Writer

fun main(args: Array<String>) {
    application {
        configure {
            width = 640
            height = 480
        }
        program {
            extend(ScreenRecorder().apply {
                maximumDuration = 5.0
                outputFile = "media/text-001.mp4"
            })
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(drawer.bounds.center, Math.abs(Math.cos(seconds)) * 300)
            }
        }
    }
}
    