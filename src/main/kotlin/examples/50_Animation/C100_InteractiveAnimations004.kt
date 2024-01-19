
package examples.`50_Animation`

import org.openrndr.animatable.Animatable
import org.openrndr.animatable.easing.Easing
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.math.Vector2

fun main() {
    application {
        program {
            class AnimatedCircle : Animatable() {
                var x = 0.0
                var y = 0.0
                var radius = 100.0
                var latch = 0.0
            
                fun shrink() {
                    // -- first stop any running animations for the radius property
                    ::radius.cancel()
                    ::radius.animate(10.0, 200, Easing.CubicInOut)
                }
            
                fun grow() {
                    ::radius.cancel()
                    ::radius.animate(Double.uniform(60.0, 90.0), 200, Easing.CubicInOut)
                }
            
                fun jump() {
                    ::x.cancel()
                    ::y.cancel()
                    ::x.animate(Double.uniform(0.0, width.toDouble()), 400, Easing.CubicInOut)
                    ::y.animate(Double.uniform(0.0, height.toDouble()), 400, Easing.CubicInOut)
                }
            
                fun update() {
                    updateAnimation()
                    if (!::latch.hasAnimations) {
                        val duration = Double.uniform(100.0, 700.0).toLong()
                        ::latch.animate(1.0, duration).completed.listen {
                            val action = listOf(::shrink, ::grow, ::jump).random()
                            action()
                        }
                    }
                }
            }
        
            val animatedCircles = List(5) {
                AnimatedCircle()
            }
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                for (ac in animatedCircles) {
                    ac.update()
                    drawer.circle(ac.x, ac.y, ac.radius)
                }
            }
        }
    }
}
    