
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
            val staticBatch = drawer.rectangleBatch {
                for (i in 0 until 1000) {
                    fill = ColorRGBa.GRAY.shade(Math.random())
                    stroke = ColorRGBa.WHITE.shade(Math.random())
                    strokeWeight = Random.double(1.0, 5.0)
                    val angle = Random.int0(20) * 18.0
                    val pos = drawer.bounds.center + Polar(angle, Random.double(100.0, 200.0)).cartesian
                    val rect = Rectangle.fromCenter(pos, width = 40.0, height = 20.0)
                    rectangle(rect, angle) // add rect to the batch
                }
            }
        
            extend {
                drawer.clear(ColorRGBa.GRAY)
                drawer.rectangles(staticBatch)
            
                // dynamic batch
                drawer.rectangles {
                    repeat(100) {
                        fill = ColorRGBa.PINK.opacify(0.05)
                        stroke = null
                        val pos = Vector2((it * 200.0) % width, 0.0)
                        val size = 5 + Math.random() * Math.random() * height
                        rectangle(Rectangle(pos, size))
                    }
                }
            }
        }
    }
}
    