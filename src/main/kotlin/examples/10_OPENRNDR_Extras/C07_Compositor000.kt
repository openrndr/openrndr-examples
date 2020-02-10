
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.Screenshots
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Add
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.ffmpeg.ScreenRecorder
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
        
            val composite = compose {
                draw {
                    drawer.fill = ColorRGBa.PINK
                    drawer.stroke = null
                    drawer.circle(width / 2.0, height / 2.0, 175.00)
                }
            
                layer {
                    draw {
                        drawer.fill = ColorRGBa.PINK
                        drawer.stroke = null
                        drawer.circle(width / 2.0, height / 2.0 + 100.0, 100.0)
                    }
                }
            }
        
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    