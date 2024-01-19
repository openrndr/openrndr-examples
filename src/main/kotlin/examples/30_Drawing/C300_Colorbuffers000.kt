
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.ColorFormat
import org.openrndr.draw.ColorType
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.loadImage
import org.openrndr.drawImage
import org.openrndr.extra.shadestyles.RadialGradient
import org.openrndr.shape.Rectangle
import java.io.File
import java.nio.ByteBuffer
import kotlin.math.sin

fun main() {
    application {
        program {
            val gradientBackground = drawImage(width, height) {
                // Draw anything here, for example a radial gradient.
                drawer.shadeStyle = RadialGradient(ColorRGBa.WHITE, ColorRGBa.PINK)
                val r = Rectangle.fromCenter(drawer.bounds.center, 800.0, 800.0)
                drawer.rectangle(r)
            }
            extend {
                drawer.image(gradientBackground)
                drawer.circle(drawer.bounds.center, sin(seconds) * 80 + 100)
            }
        }
    }
}
    