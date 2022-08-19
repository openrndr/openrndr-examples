
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.circleBatch
import org.openrndr.draw.rectangleBatch
import org.openrndr.shape.Circle
import org.openrndr.extra.noise.Random
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

fun main() {
    application {
        program {
            extend {
                drawer.clear(ColorRGBa.BLACK)
                drawer.points {
                    repeat(20000) {
                        fill = rgb((it * 0.01 - seconds) % 1)
                        point((it * it * 0.011) % width, (it * 4.011) % height)
                    }
                }
            }
        }
    }
}
    