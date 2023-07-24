
package examples.`04_Drawing`

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
            extend {
                val area = drawer.bounds.offsetEdges(-100.0)
                val positions = List(400) {
                    Random.point(area)
                }
                val radii = List(400) {
                    Random.double(5.0, 50.0)
                }
                drawer.circles(positions, radii)
            }
        }
    }
}
    