
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.fx.blur.*
import org.openrndr.extra.fx.color.ChromaticAberration
import org.openrndr.extra.fx.color.ColorCorrection
import org.openrndr.extra.fx.color.LumaOpacity
import org.openrndr.extra.fx.color.LumaThreshold
import org.openrndr.extra.fx.distort.*
import org.openrndr.extra.fx.dither.ADither
import org.openrndr.extra.fx.dither.CMYKHalftone
import org.openrndr.extra.fx.edges.LumaSobel
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.extra.vfx.Contour
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            val blurred = colorBuffer(image.width, image.height)
            val blur = FrameBlur()
            val rt = renderTarget(width, height) {
                colorBuffer()
            }
        
            extend {
                drawer.isolatedWithTarget(rt) {
                    drawer.background(ColorRGBa.BLACK)
                    drawer.image(image, cos(seconds * PI) * 40.0, sin(seconds * PI) * 40.0)
                }
            
                blur.blend = 0.01
                blur.apply(rt.colorBuffer(0), blurred)
                drawer.image(blurred)
            }
        }
    }
}
    