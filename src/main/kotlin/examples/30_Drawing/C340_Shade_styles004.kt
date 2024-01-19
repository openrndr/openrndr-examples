
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
            val sphere = sphereMesh(32, 32, 0.6)
            val style = shadeStyle {
                vertexTransform = """
                        vec3 p = x_position * 8.0 + p_seconds;
                        // displace the vertices
                        x_position.x += sin(p.y) * 0.1;
                        x_position.y += sin(p.z) * 0.1;
                        x_position.z += sin(p.x) * 0.1;
                    """.trimIndent()
            
                fragmentTransform = """
                        vec3 c = sin(v_worldPosition) * 0.5 + 0.5;
                        x_fill = vec4(c, 1.0);
                    """.trimIndent()
            }
        
            val camera = OrbitalCamera(Vector3.UNIT_Z, Vector3.ZERO)
        
            extend(camera)
            extend {
                camera.rotate(0.2, 0.0)
                style.parameter("seconds", seconds)
                drawer.shadeStyle = style
                drawer.vertexBuffer(sphere, DrawPrimitive.LINES)
            }
        }
    }
}
    