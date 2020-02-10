
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
                    drawer.circle(width / 2.0 + sin(seconds * PI * 0.5) * 100.0, height / 2.0, 175.0)
                }
            
                layer {
                    blend(Add())
                    draw {
                        drawer.fill = ColorRGBa.PINK
                        drawer.stroke = null
                        drawer.circle(width / 2.0, height / 2.0 + cos(seconds * PI * 0.5) * 100.0, 100.0)
                    }
                    post(ApproximateGaussianBlur()) {
                        // -- this is actually a function that is called for every draw
                        window = 25
                        sigma = cos(seconds * Math.PI * 0.25) * 10.0 + 10.01
                    }
                }
            }
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    