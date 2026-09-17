
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
            val image = loadImage("data/images/cheeta.jpg")
            val font = loadFont("data/fonts/default.otf", 144.0)
            extend {
                run {
                    drawer.shadeStyle = gradient<ColorRGBa> {
                        stops[0.0] = ColorRGBa.PINK
                        stops[1.0] = ColorRGBa.RED
                        radial {
                            radius = 0.5
                            center = Vector2(cos(seconds), sin(seconds * 2.0)) * 0.5 + 0.5
                        }
                    }
                }
    
                drawer.rectangle(80.0, 40.0, 200.0, 200.0)
                drawer.circle(180.0, 340.0, 90.0)
                drawer.image(image, 300.0, 40.0, 640 * (200 / 480.0), 200.0)
                drawer.fontMap = font
                drawer.text("OPEN", 300.0, 340.0)
                drawer.text("RNDR", 300.0, 420.0)
            }
        }
    }
}
    