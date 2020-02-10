
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.fx.blur.*
import org.openrndr.extra.fx.color.ChromaticAberration
import org.openrndr.extra.fx.color.ColorCorrection
import org.openrndr.extra.fx.color.LumaOpacity
import org.openrndr.extra.fx.color.LumaThreshold
import org.openrndr.extra.fx.distort.BlockRepeat
import org.openrndr.extra.fx.distort.HorizontalWave
import org.openrndr.extra.fx.distort.StackRepeat
import org.openrndr.extra.fx.distort.VerticalWave
import org.openrndr.extra.fx.dither.ADither
import org.openrndr.extra.fx.dither.CMYKHalftone
import org.openrndr.extra.fx.edges.LumaSobel
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            val filter = LumaOpacity()
            val filtered = colorBuffer(image.width, image.height)
        
            extend {
                // -- a pink background to demonstrate the introduced transparencies
                drawer.background(ColorRGBa.PINK)
                filter.backgroundOpacity = 0.0
                filter.foregroundOpacity = 1.0
                filter.backgroundLuma = cos(seconds * PI) * 0.25 + 0.25
                filter.foregroundLuma = 1.0 - (cos(seconds * PI) * 0.25 + 0.25)
            
                filter.apply(image, filtered)
                drawer.image(filtered)
            }
        }
    }
}
    