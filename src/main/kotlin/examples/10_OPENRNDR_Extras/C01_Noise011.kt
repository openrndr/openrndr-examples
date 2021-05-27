
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
            val cb = colorBuffer(width, height)
            val vn = ValueNoise()
            extend {
                vn.scale = Vector2.ONE * 4.0
                vn.gain = Vector4.ONE * 0.5
                vn.octaves = 8
                vn.apply(emptyArray(), cb)
                drawer.image(cb)
            }
        }
    }
}
    