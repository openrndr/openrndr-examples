
package examples.`30_Drawing`

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
            val style = shadeStyle {
                // Define the `random` function and declare a `c`
                // variable to pass to the fragment shader.
                vertexPreamble = """
                        float random(vec2 st) {
                            return fract(sin(dot(st.xy,
                                vec2(12.9898, 78.233))) * 43758.5453123);
                        }
                        out vec3 c;
                    """.trimIndent()
            
                // Calculate the value of `c` per vertex.
                // It will get interpolated by the GPU.
                vertexTransform = """
                        c.r = random(x_position.xy);
                        c.g = random(x_position.yx);
                        c.b = random(x_position.xy + 1.0);
                    """.trimIndent()
            
                // Declare a `c` variable to receive from the vertex shader.
                fragmentPreamble = "in vec3 c;"
                // Use the value of `c` to set the color of a pixel.
                fragmentTransform = "x_fill.rgb = c;"
            }
            extend {
                drawer.shadeStyle = style
                repeat(7) {
                    // Notice how we do not set `drawer.fill`.
                    drawer.rectangle(50.0 + it * 77, 50.0, 70.0, 390.0)
                }
            }
        }
    }
}
    