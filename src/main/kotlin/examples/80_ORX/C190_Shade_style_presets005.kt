
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.extra.color.presets.ORANGE
import org.openrndr.extra.color.presets.PURPLE
import org.openrndr.extra.color.spaces.ColorOKLABa
import org.openrndr.extra.color.spaces.toOKLABa
import org.openrndr.extra.shadestyles.fills.SpreadMethod
import org.openrndr.extra.shadestyles.fills.gradients.gradient
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.PINK)
                repeat(3) {
                    val e = it * 0.02
                    drawer.shadeStyle = gradient<ColorRGBa> {
                        stops[0.0] = ColorRGBa.WHITE
                        stops[1.0] = ColorRGBa.BLACK
                        domainWarpFunction = "vec2 domainWarp(vec2 p) { return p + sin(p * 50.0) * $e; }"
                        radial { }
                    }
                    drawer.rectangle(50.0, 50.0 + it * 130.0, width - 100.0, 110.0)
                }
            }
        }
    }
}
    