
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
            
                // Use `var` for your annotated variables.
                // `val` will produce no UI element!
                @DoubleParameter("z", -10.0, 10.0)
                val z: Double = 0.0
            }
        
            // -- this is why we wanted to keep a reference to gui
            gui.add(settings, "Settings")
        
            // -- pitfall: the `extend` has to take place after gui is populated
            extend(gui)
            extend {
            
                // -- use our settings
                drawer.circle(settings.x, settings.y, 100.0)
            }
        }
    }
}
    