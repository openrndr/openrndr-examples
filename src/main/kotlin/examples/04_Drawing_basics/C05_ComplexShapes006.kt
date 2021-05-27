
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
            // -- create a contour from Rectangle object
            val c = Rectangle(100.0, 100.0, width - 200.0, height - 200.0).contour.reversed
        
            extend {
                drawer.fill = null
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(c)
                for (i in 1 until 10) {
                    val o = c.offset((cos(seconds * 0.5 + 0.5)) * i * 10.0, SegmentJoin.BEVEL)
                    drawer.contour(o)
                }
            }
        }
    }
}
    