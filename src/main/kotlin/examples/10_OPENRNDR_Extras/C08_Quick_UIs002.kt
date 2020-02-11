
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.compositor.blend
import org.openrndr.extra.compositor.compose
import org.openrndr.extra.compositor.layer
import org.openrndr.extra.compositor.post
import org.openrndr.extra.fx.blend.Multiply
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.parameters.ColorParameter
import org.openrndr.extra.parameters.Description
import org.openrndr.extra.parameters.DoubleParameter
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.extra.compositor.draw
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
            val gui = GUI()
            val settings = object {
                @DoubleParameter("x", 0.0, 770.0)
                var x: Double = 385.0
            
                @DoubleParameter("y", 0.0, 500.0)
                var y: Double = 250.0
            }
            val rt = renderTarget(width, height) {
                colorBuffer()
            }
        
            val filtered = colorBuffer(width, height)
            val blur = ApproximateGaussianBlur()
        
            gui.add(blur)
            gui.add(settings, "Settings")
            // -- pitfall: the extend has to take place after gui is populated
            extend(gui)
            extend {
                drawer.isolatedWithTarget(rt) {
                    drawer.background(ColorRGBa.BLACK)
                    // -- use our settings
                    drawer.circle(settings.x, settings.y, 100.0)
                }
                blur.apply(rt.colorBuffer(0), filtered)
                drawer.image(filtered)
            }
        }
    }
}
    