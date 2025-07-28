
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.isolatedWithTarget
import org.openrndr.draw.renderTarget
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Multiply
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.gui.addTo
import org.openrndr.extra.parameters.ColorParameter
import org.openrndr.extra.parameters.DoubleParameter
import kotlin.math.cos
import kotlin.math.sin

fun main() {
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
            // -- pitfall: the `extend` has to take place after gui is populated
            extend(gui)
            extend {
                drawer.isolatedWithTarget(rt) {
                    drawer.clear(ColorRGBa.BLACK)
                    // -- use our settings
                    drawer.circle(settings.x, settings.y, 100.0)
                }
                blur.apply(rt.colorBuffer(0), filtered)
                drawer.image(filtered)
            }
        }
    }
}
    