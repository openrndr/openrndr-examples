
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.circleBatch
import org.openrndr.draw.rectangleBatch
import org.openrndr.shape.Circle
import org.openrndr.extra.noise.Random
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

fun main() {
    application {
        program {
            val staticBatch = drawer.circleBatch {
                for (i in 0 until 2000) {
                    fill = ColorRGBa.GRAY.shade(Math.random())
                    stroke = ColorRGBa.WHITE.shade(Math.random())
                    strokeWeight = 1 + Math.random() * 5
                    val pos = Random.ring2d(100.0, 200.0) as Vector2
                    circle(pos + drawer.bounds.center, 5 + Math.random() * 20)
                }
            }
        
            extend {
                drawer.clear(ColorRGBa.GRAY)
                drawer.circles(staticBatch)
            
                // dynamic batch
                drawer.circles {
                    repeat(100) {
                        fill = ColorRGBa.PINK.shade(Math.random())
                        stroke = null
                        val pos = Vector2((it * 160.0) % width, height * 1.0)
                        val radius = Random.double(2.5, 110.0 - it) * 2
                        circle(pos, radius)
                    }
                }
            }
        }
    }
}
    