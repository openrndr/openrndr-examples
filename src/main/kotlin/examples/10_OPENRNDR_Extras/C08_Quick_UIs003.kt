
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
                var y: Double = 385.0
            
                @DoubleParameter("separation", -150.0, 150.0)
                var separation: Double = 0.0
            
                @ColorParameter("background")
                var background = ColorRGBa.PINK
            }
            gui.add(settings, "Settings")
        
            // -- create a composite
            val composite = compose {
                layer {
                    draw {
                        drawer.clear(settings.background)
                    }
                }
                layer {
                    layer {
                        draw {
                            drawer.fill = ColorRGBa.RED
                            drawer.circle(settings.x - settings.separation, settings.y, 200.0)
                        }
                    }
                    layer {
                        draw {
                            drawer.fill = ColorRGBa.BLUE
                            drawer.circle(settings.x + settings.separation, settings.y, 200.0)
                        }
                        // -- add blend to layer and side
                        blend(gui.add(Multiply(), "Multiply blend"))
                    }
                    // -- add post to layer and sidebar
                    post(gui.add(ApproximateGaussianBlur())) {
                        sigma = sin(seconds * PI) * 10.0 + 10.01
                        window = 25
                    }
                }
            }
            extend(gui)
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    