
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.tint

import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.noise.*
import org.openrndr.extra.noise.filters.*
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import kotlin.math.abs

fun main(args: Array<String>) {
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
                            t < 3.0 -> abs(fbm(100, x * s, y * s, t, ::perlinLinear)) * 16.0
                            t < 6.0 -> billow(100, x * s, y * s, t, ::perlinLinear) * 2.0
                            else -> rigid(100, x * s, y * s, t, ::perlinLinear) * 16.0
                        }
                        drawer.circle(x * 1.0, y * 1.0, radius)
                    }
                }
            }
        }
    }
}
    