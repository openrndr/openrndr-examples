
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.shadeStyle
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder

fun main(args: Array<String>) {
    application {
        program {
            extend {
                drawer.shadeStyle = shadeStyle {
                    fragmentTransform = "x_fill.rgb = vec3(1.0, 0.0, 0.0);"
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.rectangle(width / 2.0 - 200.0, height / 2.0 - 200.0, 400.0, 400.00)
            }
        }
    }
}
    