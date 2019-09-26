
package examples.`11_Advanced_Topics`

import org.openrndr.application
import org.openrndr.draw.ComputeShader
import java.io.File

fun main(args: Array<String>) {
    application {
        program {
            val cs = ComputeShader.fromFile(File("data/compute-shaders/fill.cs"))
        
    
            extend {
            }
        }
    }
}
    