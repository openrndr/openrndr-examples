
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadFont
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.shape.Rectangle
import org.openrndr.text.Writer

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend(ScreenRecorder()) {
                outputFile = "media/text-004.mp4"
                maximumDuration = 15.0
                quitAfterMaximum = true
                frameRate = 60
            }
            val font = loadFont("file:data/IBMPlexMono-Bold.ttf", 24.0)
            extend {
                drawer.background(ColorRGBa.PINK)
                drawer.fontMap = font
                drawer.fill = ColorRGBa.BLACK
            
                val writer = Writer(drawer)
                // -- animate the text leading
                writer.style.leading = Math.cos(seconds) * 20.0 + 24.0
                // -- animate the text tracking
                writer.style.tracking = Math.sin(seconds) * 20.0 + 24.0
                writer.apply {
                    writer.box = Rectangle(40.0, 40.0, width - 80.0, height - 80.0)
                    newLine()
                    text("Here is a line of text..")
                    newLine()
                    text("Here is another line of text..")
                    newLine()
                    text("Let's even throw another line of text in, for good measure! yay")
                }
            }
        }
    }
}
    