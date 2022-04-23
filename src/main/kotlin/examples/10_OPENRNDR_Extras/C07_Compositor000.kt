
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
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
                    drawer.fill = ColorRGBa.PINK
                    drawer.stroke = null
                    drawer.circle(width / 2.0, height / 2.0, 175.00)
                }
            
                layer {
                    draw {
                        drawer.fill = ColorRGBa.PINK
                        drawer.stroke = null
                        drawer.circle(width / 2.0, height / 2.0 + 100.0, 100.0)
                    }
                }
            }
        
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    