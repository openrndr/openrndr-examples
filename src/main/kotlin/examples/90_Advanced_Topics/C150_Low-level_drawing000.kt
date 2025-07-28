
package examples.`90_Advanced_Topics`

import org.openrndr.application
import org.openrndr.draw.DrawPrimitive
import org.openrndr.draw.Shader
import org.openrndr.draw.vertexBuffer
import org.openrndr.draw.vertexFormat
import org.openrndr.internal.Driver
import org.openrndr.math.Vector3

fun main() {
    application {
        program {
            val geometry = vertexBuffer(vertexFormat {
                position(3) // -- this attribute is named "position"
            }, 3)
        
            geometry.put {
                for (i in 0 until geometry.vertexCount) {
                    write(Vector3(2.0 * Math.random() - 1.0, 2.0 * Math.random() - 1.0, 0.0))
                }
            }
        
            // -- code for the vertex shader
            val vs = """
            #version 330                
            in vec3 a_position;  // -- driver adds a_ prefix (a for attribute)
            void main() {
                gl_Position = vec4(a_position, 1.0);                
            }
            """
        
            // -- code for the fragment shader
            val fs = """
            #version 330
            out vec4 o_output;
            void main() {
                o_output = vec4(1.0);                                                                                                                
            }                                                                
            """
        
            val shader = Shader.createFromCode(vsCode = vs, fsCode = fs, name = "custom-shader")
        
            extend {
                shader.begin()
                Driver.instance.drawVertexBuffer(shader, listOf(geometry), DrawPrimitive.TRIANGLES, 0, 3)
                shader.end()
            }
        }
    }
}
    