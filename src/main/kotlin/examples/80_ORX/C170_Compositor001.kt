
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
                draw {
                    drawer.fill = ColorRGBa.PINK
                    drawer.stroke = null
                    drawer.circle(width / 2.0, height / 2.0, 175.0)
                }
            
                layer {
                    blend(Add()) {
                        clip = true
                    }
                    draw {
                        drawer.fill = ColorRGBa.PINK
                        drawer.stroke = null
                        drawer.circle(width / 2.0, height / 2.0 + 100.0, 100.0)
                    }
                    post(ApproximateGaussianBlur()) {
                        window = 25
                        sigma = 10.00
                    }
                }
            }
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    