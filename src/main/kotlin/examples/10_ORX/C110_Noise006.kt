
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
            val noise = fbmFunc3D(::simplex, octaves = 3)
            extend {
                drawer.fill = null
                drawer.stroke = ColorRGBa.PINK
                drawer.lineCap = LineCap.ROUND
                drawer.strokeWeight = 1.5
                val t = seconds
                for (y in 4 until height step 8) {
                    for (x in 4 until width step 8) {
                        val g = gradient3D(noise, 100, x * 0.002, y * 0.002, t, 0.002).xy
                        drawer.lineSegment(Vector2(x * 1.0, y * 1.0) - g * 1.0, Vector2(x * 1.0, y * 1.0) + g * 1.0)
                    }
                }
            }
        }
    }
}
    