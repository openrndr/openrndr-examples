
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.color.LumaOpacity

import org.openrndr.poissonfill.PoissonBlend
import org.openrndr.poissonfill.PoissonFill
import org.openrndr.shape.Rectangle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val c = compose {
                layer {
                    draw {
                        drawer.stroke = null
                        drawer.fill = ColorRGBa.RED
                        drawer.circle((cos(seconds) * 0.5 + 0.5) * width, (sin(seconds * 0.5) * 0.5 + 0.5) * height, 20.0)
                        drawer.fill = ColorRGBa.PINK
                        drawer.circle((sin(seconds * 2.0) * 0.5 + 0.5) * width, (cos(seconds) * 0.5 + 0.5) * height, 20.0)
                    
                        drawer.fill = ColorRGBa.BLACK
                        drawer.circle((sin(seconds * 1.0) * 0.5 + 0.5) * width, (cos(seconds * 2.0) * 0.5 + 0.5) * height, 20.0)
                    }
                    post(PoissonFill())
                }
                layer {
                    // -- an extra layer just to demonstrate where the original data points are drawn
                    draw {
                        drawer.stroke = ColorRGBa.WHITE
                        drawer.strokeWeight = 5.0
                        drawer.fill = ColorRGBa.RED
                        drawer.circle((cos(seconds) * 0.5 + 0.5) * width, (sin(seconds * 0.5) * 0.5 + 0.5) * height, 20.0)
                        drawer.fill = ColorRGBa.PINK
                        drawer.circle((sin(seconds * 2.0) * 0.5 + 0.5) * width, (cos(seconds) * 0.5 + 0.5) * height, 20.0)
                    
                        drawer.fill = ColorRGBa.BLACK
                        drawer.circle((sin(seconds * 1.0) * 0.5 + 0.5) * width, (cos(seconds * 2.0) * 0.5 + 0.5) * height, 20.0)
                    }
                }
            }
            extend {
                c.draw(drawer)
            }
        }
    }
}
    