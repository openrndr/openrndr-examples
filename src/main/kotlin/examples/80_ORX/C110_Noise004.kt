
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.draw.colorBuffer
import org.openrndr.extra.noise.*
import org.openrndr.extra.noise.filters.CellNoise
import org.openrndr.extra.noise.filters.HashNoise
import org.openrndr.extra.noise.filters.SimplexNoise3D
import org.openrndr.extra.noise.filters.SpeckleNoise
import org.openrndr.extra.noise.filters.ValueNoise
import org.openrndr.extra.noise.primitives.random
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import kotlin.math.absoluteValue

fun main() {
    application {
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                val s = 0.0080
                val t = seconds
                for (y in 4 until height step 8) {
                    for (x in 4 until width step 8) {
                        val radius = when {
                            t < 3.0 -> fbm(135, x * s, y * s, t, ::perlinLinear).absoluteValue * 16.0
                            t < 6.0 -> billow(471, x * s, y * s, t, ::perlinLinear) * 2.0
                            else -> rigid(193, x * s, y * s, t, ::perlinLinear) * 16.0
                        }
                        drawer.circle(x * 1.0, y * 1.0, radius)
                    }
                }
            }
        }
    }
}
    