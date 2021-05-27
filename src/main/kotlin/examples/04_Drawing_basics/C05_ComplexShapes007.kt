
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
            val c = contour {
                moveTo(width * (1.0 / 2.0), height * (1.0 / 5.0))
                curveTo(width * (1.0 / 4.0), height * (2.0 / 5.0), width * (3.0 / 4.0), height * (3.0 / 5.0), width * (2.0 / 4.0), height * (4.0 / 5.0))
            }
            extend {
                drawer.stroke = ColorRGBa.PINK
                drawer.strokeWeight = 2.0
                drawer.contour(c)
                for (i in -8..8) {
                    val o = c.offset(i * 10.0 * (cos(seconds * 0.5 + 0.5)))
                    drawer.contour(o)
                }
            }
        }
    }
}
    