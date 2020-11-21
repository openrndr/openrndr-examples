
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.noise.random
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.sin

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            val center = Vector2(width * 0.5, height * 0.5)
            val circle = Circle(center, 200.0)
            val sineWaves = drawComposition {
                val sine = { x: Double, y: Double -> Vector2(x, y + sin(x / 50.0) * 10.0) }
                stroke = ColorRGBa.PINK
                strokeWeight = 4.0

                for (y in -50..height step 20) {
                    val cs = contours {
                        moveTo(sine(0.0, y.toDouble()))
                        for (x in 0..width step 10) {
                            if (random() < -0.5) {
                                moveTo(sine(x.toDouble(), cursor.y))
                            } else {
                                lineTo(sine(x.toDouble(), cursor.y))
                            }
                        }
                    }
                    cs.forEach { shape(intersection(it, circle.shape)) }
                }
                shape(circle.shape)
            }
            extend {
                drawer.lineCap = LineCap.ROUND
                drawer.composition(sineWaves)
            }
        }
    }
}
    