
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.extra.color.colormatrix.tint
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Add
import org.openrndr.extra.fx.blend.Normal
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.fx.distort.HorizontalWave
import org.openrndr.extra.fx.distort.VerticalWave
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.extra.textwriter.Cursor
import org.openrndr.extra.textwriter.writer
import org.openrndr.shape.Rectangle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val composite = compose {
                layer {
                    // -- load the image inside the layer
                    val image = loadImage("data/images/cheeta.jpg")
                    draw {
                        drawer.image(image)
                    }
                }
            
                // -- add a second layer with text and a drop shadow
                layer {
                    // -- notice how we load the font inside the layer
                    // -- this only happens once
                    val font = loadFont("data/fonts/default.otf", 112.0)
                    draw {
                        drawer.fill = ColorRGBa.BLACK
                        drawer.fontMap = font
                        val message = "HELLO WORLD"
                        writer {
                            box = Rectangle(0.0, 0.0, width * 1.0, height * 1.0)
                            val w = textWidth(message)
                            cursor = Cursor((width - w) / 2.0, height / 2.0)
                            text(message)
                        }
                    }
                    // -- this effect is processed first
                    post(HorizontalWave()) {
                        amplitude = cos(seconds * 3) * 0.1
                        frequency = sin(seconds * 2) * 4
                        segments = (1 + Math.random() * 20).toInt()
                        phase = seconds
                    }
                    // -- this is the second effect
                    post(VerticalWave()) {
                        amplitude = sin(seconds * 3) * 0.1
                        frequency = cos(seconds * 2) * 4
                        segments = (1 + Math.random() * 20).toInt()
                        phase = seconds
                    }
                    // -- and this effect is processed last
                    post(ApproximateGaussianBlur()) {
                        sigma = cos(seconds * 2) * 5.0 + 5.01
                        window = 25
                    }
                }
            }
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    