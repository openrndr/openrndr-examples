
package examples.`80_ORX`

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
            val filter = ChromaticAberration()
            val filtered = colorBuffer(image.width, image.height)
        
            extend {
                filter.aberrationFactor = cos(seconds * 2) * 10.0
                filter.apply(image, filtered)
                drawer.image(filtered)
            }
        }
    }
}
    