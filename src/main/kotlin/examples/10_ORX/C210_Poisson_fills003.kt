
package examples.`10_ORX`

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
            val image = loadImage("data/images/cheeta.jpg")
        
            val c = compose {
                layer {
                    draw {
                        drawer.image(image)
                    }
                }
                layer {
                    draw {
                        drawer.stroke = ColorRGBa.GRAY
                        drawer.fill = null
                        drawer.strokeWeight = 40.0
                        drawer.circle((cos(seconds) * 0.5 + 0.5) * width, (sin(seconds * 0.5) * 0.5 + 0.5) * height, 120.0)
                    }
                    post(LumaOpacity()) {
                        this.backgroundLuma = 0.25
                    }
                    blend(PoissonBlend())
                }
            }
            extend {
                c.draw(drawer)
            }
        }
    }
}
    