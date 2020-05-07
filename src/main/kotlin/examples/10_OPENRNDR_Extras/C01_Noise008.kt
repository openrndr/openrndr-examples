
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
            extend(ScreenRecorder()) {
                outputFile = "media/orx-noise-filter-008.mp4"
                quitAfterMaximum = true
                maximumDuration = 9.0
            }
        
            val cb = colorBuffer(width, height)
            val sn = SimplexNoise3D()
            extend {
                sn.seed = Vector3(0.0, 0.0, seconds * 0.1)
                sn.scale = Vector3.ONE * 2.0
                sn.octaves = 8
                sn.premultipliedAlpha = false
                sn.apply(emptyArray(), cb)
                drawer.image(cb)
            }
        }
    }
}
    