
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
            val filter = DropShadow()
            val filtered = colorBuffer(image.width, image.height)
        
            val rt = renderTarget(width, height) {
                colorBuffer()
            }
        
            extend {
                drawer.isolatedWithTarget(rt) {
                    drawer.background(ColorRGBa.TRANSPARENT)
                    drawer.image(image, (image.width - image.width * 0.8) / 2, (image.height - image.height * 0.8) / 2, image.width * 0.8, image.height * 0.8)
                }
                // -- need a pink background because the filter introduces transparent areas
                drawer.background(ColorRGBa.PINK)
                filter.window = (cos(seconds * 0.5 * PI) * 16 + 16).toInt()
                filter.xShift = cos(seconds * PI) * 16.0
                filter.yShift = sin(seconds * PI) * 16.0
                filter.apply(rt.colorBuffer(0), filtered)
                drawer.image(filtered)
            }
        }
    }
}
    