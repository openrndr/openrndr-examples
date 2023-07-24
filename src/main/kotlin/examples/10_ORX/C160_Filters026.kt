
package examples.`10_ORX`

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
import org.openrndr.extra.fx.edges.Contour
import org.openrndr.extra.fx.edges.EdgesWork
import org.openrndr.extra.fx.edges.LumaSobel
import org.openrndr.extra.fx.patterns.Checkers
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.extra.shadestyles.linearGradient
import org.openrndr.extra.imageFit.imageFit

import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() {
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
                    drawer.clear(ColorRGBa.TRANSPARENT)
                    drawer.image(image, (image.width - image.width * 0.8) / 2, (image.height - image.height * 0.8) / 2, image.width * 0.8, image.height * 0.8)
                }
                // -- need a pink background because the filter introduces transparent areas
                drawer.clear(ColorRGBa.PINK)
                filter.window = (cos(seconds) * 16 + 16).toInt()
                filter.xShift = cos(seconds * 2) * 16.0
                filter.yShift = sin(seconds * 2) * 16.0
                filter.apply(rt.colorBuffer(0), filtered)
                drawer.image(filtered)
            }
        }
    }
}
    