
package examples.drawing.`01_text`

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
        program {
            extend(SingleScreenshot().apply {
                outputFile = "media/text-003.png"
            })
            extend {
                drawer.background(ColorRGBa.RED)
                val writer = Writer(drawer)
                run {
                    writer.box = Rectangle(Vector2(100.0, 100.0), 400.0, 400.0)
                }
                run {
                    writer.box = Rectangle(Vector2(100.0, 100.0), Double.`POSITIVE_INFINITY`, Double.`POSITIVE_INFINITY`)
                }
                run {
                    writer.box = drawer.bounds
                    writer.box = drawer.bounds.offsetEdges(-50.0)
                }
            }
        }
    }
}
    