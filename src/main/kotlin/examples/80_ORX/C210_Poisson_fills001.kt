
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
                    val image = loadImage("data/images/cheeta.jpg")
                    draw {
                        drawer.image(image, Rectangle((cos(seconds) * 0.5 + 0.5) * 100.0, (sin(seconds) * 0.5 + 0.5) * 100.0, 200.0, 200.0), Rectangle(width / 2 - 100.0, height / 2.0 - 100.0, 200.0, 200.0))
                    }
                    post(PoissonFill())
                }
            }
            extend {
                c.draw(drawer)
            }
        }
    }
}
    