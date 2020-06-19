
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
                draw {
                    drawer.clear(ColorRGBa.PINK)
                }
                layer {
                    // -- we nest layers to prevent the text layer to be blend with the background
                    // -- before it is blend with the image layer
                    layer {
                        // -- notice how we load the font inside the layer
                        // -- this only happens once
                        val font = loadFont("data/IBMPlexMono-Bold.ttf", 112.0)
                        draw {
                            drawer.fill = ColorRGBa.WHITE
                            drawer.fontMap = font
                            val message = "HELLO WORLD"
                            writer {
                                val w = textWidth(message)
                                cursor = Cursor((width - w) / 2.0, height / 2.0 + cos(seconds * PI * 0.2) * 200.0)
                                text(message)
                            }
                        }
                    }
                    layer {
                        // -- again, loading resources inside the layer is perfectly fine
                        // -- it is also a good way to keep code free of clutter
                        val image = loadImage("data/images/cheeta.jpg")
                    
                        // -- we use a normal blend here
                        blend(Normal()) {
                            // -- and we set clip to true
                            clip = true
                        }
                        draw {
                            // -- we modify the image opacity as a demonstration
                            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.opacify(cos(seconds * PI)))
                            drawer.image(image)
                        }
                    }
                }
            }
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    