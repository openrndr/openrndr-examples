
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.camera.OrbitalCamera
import org.openrndr.extra.meshgenerators.sphereMesh
import org.openrndr.extra.shapes.hobbycurve.hobbyCurve
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            backgroundColor = ColorRGBa.WHITE
            extend {
                val c = hobbyCurve(List(10) {
                    Vector2(it * width / 9.0, height * 0.5 + sin(seconds + it) * 100.0)
                }, false)
                drawer.shadeStyle = shadeStyle {
                    fragmentTransform = """
                        x_stroke = texture( 
                            p_image, vec2(c_contourPosition / p_len, 1.0 - va_texCoord0.x)
                        );
                    """.trimIndent()
                    parameter("image", image)
                    parameter("len", c.length)
                }
                drawer.strokeWeight = 80.0
                drawer.contour(c)
            }
        }
    }
}
    