
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.ColorType
import org.openrndr.draw.loadImage
import org.openrndr.extra.compositor.*
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
                    post(InnerGlow()) {
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
    