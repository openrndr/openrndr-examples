
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
            // -- load a source image
            val image = loadImage("data/images/cheeta.jpg")
        
            // -- create a filter
            val blur = BoxBlur()
        
            // -- create a colorBuffer where to store the result
            val blurred = colorBuffer(image.width, image.height)
        
            extend {
                // -- configure the filter
                blur.window = (cos(seconds * 2) * 4.0 + 5.0).toInt()
            
                // -- filter.apply(source, target)
                blur.apply(image, blurred)
            
                // -- draw the result
                drawer.image(blurred)
            }
        }
    }
}
    