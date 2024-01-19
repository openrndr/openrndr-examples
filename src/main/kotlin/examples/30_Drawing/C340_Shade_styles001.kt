
package examples.`30_Drawing`

import org.intellij.lang.annotations.Language
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.camera.OrbitalCamera
import org.openrndr.extra.meshgenerators.sphereMesh
import org.openrndr.math.Vector3
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            extend {
                drawer.shadeStyle = shadeStyle {
                    fragmentTransform = """
                        | float c = cos(c_screenPosition.x * 0.1) * 0.5 + 0.5;
                        | x_fill.rgb *= vec3(c, c, c);
                        """.trimMargin()
                }
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.rectangle(width / 2.0 - 200.0, height / 2.0 - 200.0, 400.0, 400.00)
            }
        }
    }
}
    