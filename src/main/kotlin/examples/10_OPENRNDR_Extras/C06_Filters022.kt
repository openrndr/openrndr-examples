
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
import org.openrndr.extra.fx.edges.Contour
import org.openrndr.extra.fx.edges.EdgesWork
import org.openrndr.extra.fx.edges.LumaSobel
import org.openrndr.extra.fx.patterns.Checkers
import org.openrndr.extra.fx.shadow.DropShadow
import org.openrndr.extra.shadestyles.linearGradient
import org.openrndr.extras.imageFit.imageFit

import org.openrndr.math.Vector2
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val composite = compose {
                layer {
                    post(Checkers())
                }
            
                layer {
                    val image = loadImage("data/images/cheeta.jpg")
                    draw {
                        drawer.imageFit(image, 0.0, 0.0, width * 1.0, height * 1.0)
                    }
                    post(PerspectivePlane()) {
                        planePitch = cos(seconds) * 22.5
                        planeYaw = sin(seconds) * 22.5
                    }
                }
            }
            extend {
                composite.draw(drawer)
            }
        }
    }
}
    