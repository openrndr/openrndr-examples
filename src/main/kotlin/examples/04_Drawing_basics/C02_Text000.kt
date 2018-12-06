
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.shape.Rectangle
import org.openrndr.text.Writer

fun main(args: Array<String>) {
    application {
        program {
            extend(SingleScreenshot()) {
                outputFile = "media/text-001.png"
            }
            val font = FontImageMap.fromUrl("file:data/IBMPlexMono-Bold.ttf", 48.0)
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fontMap = font
                drawer.fill = ColorRGBa.BLACK
                drawer.text("HELLO WORLD", width / 2.0 - 100.0, height / 2.0)
            }
        }
    }
}
    