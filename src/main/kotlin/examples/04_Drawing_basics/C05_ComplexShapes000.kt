
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.cos

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                val c = contour {
                    moveTo(Vector2(width / 2.0 - 150.0, height / 2.0 - 150.00))
                    // -- here `cursor` points to the end point of the previous command
                    lineTo(cursor + Vector2(300.0, 0.0))
                    lineTo(cursor + Vector2(0.0, 300.0))
                    lineTo(anchor)
                    close()
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.contour(c)
            }
        }
    }
}
    