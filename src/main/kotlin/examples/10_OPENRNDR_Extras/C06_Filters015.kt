
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
            val filter = Tiles()
            val filtered = colorBuffer(image.width, image.height)
        
            extend {
                filter.rotation = seconds * 45.0
                filter.xSegments = (10 + cos(seconds * PI) * 5.0).toInt()
                filter.ySegments = 30
                filter.apply(image, filtered)
                drawer.image(filtered)
            }
        }
    }
}
    