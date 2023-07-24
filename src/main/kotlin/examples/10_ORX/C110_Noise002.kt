
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
                val scale = 0.0150
                for (y in 16 until height step 32) {
                    for (x in 16 until width step 32) {
                        val radius = valueLinear(100, x * scale, y * scale) * 16.0 + 16.0
                        drawer.circle(x * 1.0, y * 1.0, radius)
                    }
                }
            }
        }
    }
}
    