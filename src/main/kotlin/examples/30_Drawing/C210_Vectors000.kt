
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.*

fun main() {
    application {
        program {
            val points = List(150) {
                drawer.bounds.center + Polar(it * 5.0, it + 100.0).cartesian
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.circles(points, 10.0)
            }
        }
    }
}
    