
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.circleBatch
import org.openrndr.draw.rectangleBatch
import org.openrndr.extra.noise.shapes.uniform
import org.openrndr.extra.noise.uniform
import org.openrndr.extra.noise.uniformRing
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.Rectangle

fun main() {
    application {
        program {
            val staticBatch = drawer.circleBatch {
                for (i in 0 until 2000) {
                    fill = ColorRGBa.GRAY.shade(Double.uniform(0.0, 1.0))
                    stroke = ColorRGBa.WHITE.shade(Double.uniform(0.0, 1.0))
                    strokeWeight = Double.uniform(1.0, 6.0)
                    val pos = Vector2.uniformRing(100.0, 200.0)
                    circle(
                        pos + drawer.bounds.center,
                        5 + Double.uniform(0.0, 1.0) * 20
                    )
                }
            }
    
            extend {
                drawer.clear(ColorRGBa.GRAY)
                drawer.circles(staticBatch)
    
                // dynamic batch
                drawer.circles {
                    repeat(100) {
                        fill = ColorRGBa.PINK.shade(Double.uniform(0.0, 1.0))
                        stroke = null
                        val pos = Vector2((it * 160.0) % width, height * 1.0)
                        val radius = Double.uniform(2.5, 110.0 - it) * 2
                        circle(pos, radius)
                    }
                }
            }
        }
    }
}
    