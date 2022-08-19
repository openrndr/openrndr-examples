
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.extra.shadestyles.angularGradient
import org.openrndr.extra.shadestyles.halfAngularGradient
import org.openrndr.extra.shadestyles.linearGradient
import org.openrndr.extra.shadestyles.radialGradient

import org.openrndr.math.Vector2
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            val font = loadFont("data/fonts/default.otf", 144.0)
            extend {
                drawer.shadeStyle = halfAngularGradient(ColorRGBa.RED, ColorRGBa.PINK, rotation = seconds * 60.0)
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
    