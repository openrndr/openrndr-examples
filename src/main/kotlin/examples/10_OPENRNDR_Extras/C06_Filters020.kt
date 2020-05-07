
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blur.*
import org.openrndr.extra.fx.color.*
import org.openrndr.extra.fx.distort.*
import org.openrndr.extra.fx.dither.ADither
import org.openrndr.extra.fx.dither.CMYKHalftone
import org.openrndr.extra.fx.dither.Crosshatch
import org.openrndr.extra.fx.edges.EdgesWork
import org.openrndr.extra.fx.edges.LumaSobel
import org.openrndr.extra.fx.patterns.Checkers
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.extra.shadestyles.linearGradient
import org.openrndr.extra.vfx.Contour
import org.openrndr.extras.imageFit.imageFit
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        program {
            val composite = compose {
                colorType = ColorType.FLOAT16
                layer {
                    val image = loadImage("data/images/cheeta.jpg")
                    draw {
                        drawer.imageFit(image, 0.0, 0.0, width * 1.0, height * 1.0)
                    }
                }
                layer {
                    draw {
                        drawer.shadeStyle = linearGradient(ColorRGBa.BLACK, ColorRGBa.WHITE)
                        drawer.stroke = null
                        val size = cos(seconds * PI * 0.5) * 100.0 + 200.0
                        drawer.rectangle(width / 2.0 - size / 2, height / 2.0 - size / 2, size, size)
                    }
                    blend(DisplaceBlend()) {
                        gain = cos(seconds * PI * 0.5) * 0.5 + 0.5
                        rotation = seconds * 45.0
                    }
                }
            }
        
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    