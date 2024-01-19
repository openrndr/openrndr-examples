
package examples.`50_Animation`

import org.openrndr.animatable.Animatable
import org.openrndr.animatable.easing.Easing
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2

fun main() {
    application {
        val animation = object : Animatable() {
            var x: Double = 0.0
        }
    
        program {
            extend {
                animation.updateAnimation()
                if (!animation.hasAnimations()) {
                    animation.apply {
                        ::x.animate(width.toDouble(), 1000, Easing.CubicInOut)
                        ::x.complete()
                        ::x.animate(0.0, 1000, Easing.CubicInOut)
                        ::x.complete()
                    }
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.circle(animation.x, height / 2.0, 100.0)
            }
        }
    }
}
    