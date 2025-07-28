
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Cursor
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Add
import org.openrndr.extra.fx.blend.Normal
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.fx.distort.HorizontalWave
import org.openrndr.extra.fx.distort.VerticalWave
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val composite = compose {
                draw {
                    drawer.clear(ColorRGBa.PINK)
                }
                layer {
                    // -- we nest layers to prevent the text layer to be blended with the background
                    // -- before it is blended with the image layer
                    layer {
                        // -- notice how we load the font inside the layer
                        // -- this only happens once
                        val font = loadFont("data/fonts/default.otf", 112.0)
                        draw {
                            drawer.fill = ColorRGBa.WHITE
                            drawer.fontMap = font
                            val message = "HELLO WORLD"
                            writer {
                                val w = textWidth(message)
                                cursor = Cursor((width - w) / 2.0, height / 2.0 + cos(seconds) * 200.0)
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
                            // -- and we set `clip` to true
                            clip = true
                        }
                        draw {
                            // -- we modify the image opacity as a demonstration
                            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.opacify(cos(seconds * 4)))
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
    