
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.fx.blur.*
import org.openrndr.extra.fx.color.*
import org.openrndr.extra.fx.distort.*
import org.openrndr.extra.fx.dither.ADither
import org.openrndr.extra.fx.dither.CMYKHalftone
import org.openrndr.extra.fx.dither.Crosshatch
import org.openrndr.extra.fx.edges.EdgesWork
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
            val filter = Crosshatch()
            val filtered = colorBuffer(image.width, image.height)
        
            extend {
                // -- need a white background because the filter introduces transparent areas
                drawer.background(ColorRGBa.WHITE)
                filter.t1 = cos(seconds * PI) * 0.25 + 0.25
                filter.t2 = filter.t1 + cos(seconds * PI * 0.5) * 0.25 + 0.25
                filter.t3 = filter.t2 + cos(seconds * PI * 0.25) * 0.25 + 0.25
                filter.t4 = filter.t3 + cos(seconds * PI * 0.125) * 0.25 + 0.25
            
                filter.apply(image, filtered)
            
                drawer.image(filtered)
            }
        }
    }
}
    