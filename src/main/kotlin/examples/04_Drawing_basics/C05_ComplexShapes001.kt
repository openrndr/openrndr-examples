
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.compound
import org.openrndr.shape.contour
import org.openrndr.shape.shape

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                val s = shape {
                    contour {
                        moveTo(Vector2(width / 2.0 - 150.0, height / 2.0 - 150.00))
                        lineTo(cursor + Vector2(300.0, 0.0))
                        lineTo(cursor + Vector2(0.0, 300.0))
                        lineTo(anchor)
                        close()
                    }
                    contour {
                        moveTo(Vector2(width / 2.0 - 80.0, height / 2.0 - 100.0))
                        lineTo(cursor + Vector2(200.0, 0.0))
                        lineTo(cursor + Vector2(0.0, 200.00))
                        lineTo(anchor)
                        close()
                    }
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.shape(s)
            }
        }
    }
}
    