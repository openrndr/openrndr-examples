
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.mod
import org.openrndr.shape.Rectangle

import java.nio.ByteBuffer
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    run {
        application {
            program {
                val at = arrayTexture(770, 576, 116)
                val renderTargets = List(at.layers) {
                    renderTarget(at.width, at.height) {
                        arrayTexture(at, it)
                    }
                }
                var index = 0
                extend {
                    drawer.background(ColorRGBa.BLACK)
                    drawer.isolatedWithTarget(renderTargets[index % renderTargets.size]) {
                        drawer.background(ColorRGBa.BLACK)
                        drawer.fill = ColorRGBa.PINK.opacify(0.5)
                        drawer.stroke = null
                        for (i in 0 until 20) {
                            drawer.circle(cos(seconds * 5.0 + i) * 256 + width / 2.0, sin(i + seconds * 6.32) * 256 + height / 2.0, 100.0)
                        }
                    }
                
                    val layers = (0 until at.layers).map {
                        mod(index - it, at.layers)
                    }
                    val rectangles = (0 until at.layers).map {
                        val span = Rectangle(0.0, it * 5.0, at.width * 1.0, 5.0)
                        span to span
                    }
                
                    drawer.image(at, layers, rectangles)
                    index++
                }
            }
        }
    }
}
    