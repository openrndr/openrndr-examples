
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.fx.blur.BoxBlur
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            // -- create offscreen render target
            val offscreen = renderTarget(width, height) {
                colorBuffer()
                depthBuffer()
            }
            // -- create blur filter
            val blur = BoxBlur()
        
            // -- create colorbuffer to hold blur results
            val blurred = colorBuffer(width, height)
        
    
            extend {
                // -- draw to offscreen buffer
                drawer.isolatedWithTarget(offscreen) {
                    clear(ColorRGBa.BLACK)
                    fill = ColorRGBa.PINK
                    stroke = null
                    circle(cos(seconds) * 100.0 + width / 2, sin(seconds) * 100.0 + height / 2.0, 100.0 + 100.0 * cos(seconds * 2.0))
                }
                // -- set blur parameters
                blur.window = 30
            
                // -- blur offscreen's color buffer into blurred
                blur.apply(offscreen.colorBuffer(0), blurred)
                drawer.image(blurred)
            }
        }
    }
}
    