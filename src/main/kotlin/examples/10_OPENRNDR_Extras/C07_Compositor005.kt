
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Add
import org.openrndr.extra.fx.blend.Normal
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.fx.blur.FrameBlur
import org.openrndr.extra.fx.distort.HorizontalWave
import org.openrndr.extra.fx.distort.VerticalWave
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.shape.Rectangle
import org.openrndr.text.Cursor
import org.openrndr.text.writer
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
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
                    val font = loadFont("data/IBMPlexMono-Bold.ttf", 112.0)
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
                        amplitude = cos(seconds * PI) * 0.1
                        frequency = sin(seconds * PI * 0.5) * 4
                        segments = (1 + Math.random() * 20).toInt()
                        phase = seconds
                    }
                    // -- this is the second effect
                    post(VerticalWave()) {
                        amplitude = sin(seconds * PI) * 0.1
                        frequency = cos(seconds * PI * 0.5) * 4
                        segments = (1 + Math.random() * 20).toInt()
                        phase = seconds
                    }
                    // -- and this effect is processed last
                    post(ApproximateGaussianBlur()) {
                        sigma = cos(seconds * 0.5 * PI) * 5.0 + 5.01
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
    