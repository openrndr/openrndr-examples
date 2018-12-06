
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.shadeStyle
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend(SingleScreenshot()) {
                outputFile = "media/shadestyles-002.png"
            }
            extend {
                drawer.shadeStyle = shadeStyle {
                    fragmentTransform = """
                        | float c = cos(c_screenPosition.x * 0.1) * 0.5 + 0.5;
                        | x_fill.rgb *= vec3(c, c, c);
                        """.trimMargin()
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.rectangle(width / 2.0 - 200.0, height / 2.0 - 200.0, 400.0, 400.00)
            }
        }
    }
}
    