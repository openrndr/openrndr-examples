
package examples.`08_Animation`

import org.openrndr.animatable.Animatable
import org.openrndr.animatable.easing.Easing
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extra.noise.uniform
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2

fun main(args: Array<String>) {
    application {
        program {
            val animation = object : Animatable() {
                var x = 0.0
                var y = 0.0
            }
        
            animation.apply {
                ::x.animate(width.toDouble(), 5000)
                ::x.complete()
                ::y.animate(height.toDouble(), 5000)
            }
        
            extend {
                animation.updateAnimation()
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.circle(animation.x, animation.y, 100.0)
            }
        }
    }
}
    