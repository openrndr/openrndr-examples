
package examples.`10_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extra.noise.*
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import kotlin.math.abs

fun main() {
    application {
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.translate(width / 2.0, height / 2.00)
                for (i in 0 until 1000) {
                    drawer.circle(Vector2.uniformRing(150.0, 250.0), 10.0)
                }
            }
        }
    }
}
    