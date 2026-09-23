
package examples.`45_Extensions`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noclear.NoClear
import org.openrndr.extra.noise.shapes.uniform
import org.openrndr.extra.shapes.hobbycurve.hobbyCurve
import kotlin.random.Random

fun main() {
    application {
        program {
            backgroundColor = ColorRGBa.PINK
            extend {
                val r = Random(3)
                hobbyCurve(List(7) {
                    drawer.bounds.offsetEdges(-150.0).uniform(r)
                }, false).equidistantPositions(200).forEach {
                    drawer.circle(it, 20.0)
                }
            }
        }
    }
}
    