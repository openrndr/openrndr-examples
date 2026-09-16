
package examples.`80_ORX`

import jdk.jfr.Description
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.BlendMode
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.isolatedWithTarget
import org.openrndr.draw.renderTarget
import org.openrndr.extra.color.presets.DARK_BLUE
import org.openrndr.extra.color.presets.DARK_ORCHID
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Multiply
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.gui.GUIAppearance
import org.openrndr.extra.gui.WindowedGUI
import org.openrndr.extra.gui.addTo
import org.openrndr.extra.parameters.*
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import org.openrndr.panel.collections.SelectableList
import org.openrndr.panel.collections.SelectableMutableList
import org.openrndr.panel.style.Color
import org.openrndr.panel.style.defaultStyles
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
                            drawer.circle(
                                settings.x - settings.separation,
                                settings.y,
                                200.0
                            )
                        }
                    }
                    layer {
                        draw {
                            drawer.fill = ColorRGBa.BLUE
                            drawer.circle(
                                settings.x + settings.separation,
                                settings.y,
                                200.0
                            )
                        }
                        // -- add blend to layer and sidebar
                        blend(gui.add(Multiply(), "Multiply blend"))
                        // -- add a layer to the sidebar to toggle it on / off
                    }.addTo(gui, "Blue layer")
                    // -- add post to layer and sidebar
                    post(gui.add(ApproximateGaussianBlur())) {
                        sigma = sin(seconds) * 10.0 + 10.01
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
    