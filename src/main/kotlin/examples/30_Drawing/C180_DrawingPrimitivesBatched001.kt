
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
            extend {
                val area = drawer.bounds.offsetEdges(-100.0)
                val positions = List(400) { area.uniform() }
                val radii = List(400) { Double.uniform(5.0, 50.0) }
                drawer.circles(positions, radii)
            }
        }
    }
}
    