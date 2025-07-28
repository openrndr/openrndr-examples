
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.ColorType
import org.openrndr.draw.loadImage
import org.openrndr.extra.compositor.compose
import org.openrndr.extra.compositor.draw
import org.openrndr.extra.compositor.layer
import org.openrndr.extra.compositor.post
import org.openrndr.extra.jumpfill.DistanceField
import org.openrndr.extra.jumpfill.fx.InnerGlow
import org.openrndr.extra.jumpfill.fx.OuterGlow
import kotlin.math.cos

fun main() {
    application {
        program {
            val c = compose {
                layer {
                    draw {
                        drawer.fill = ColorRGBa.PINK
                        drawer.circle(width / 2.0, height / 2.0, 200.0)
                    }
                    post(OuterGlow()) {
                        this.width = (cos(seconds) * 0.5 + 0.5) * 100.0
                    }
                }
            }
            extend {
                c.draw(drawer)
            }
        }
    }
}
    