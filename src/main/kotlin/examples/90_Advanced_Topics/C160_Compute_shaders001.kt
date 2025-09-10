
package examples.`90_Advanced_Topics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.draw.font.BufferAccess
import java.io.File

fun main() {
    application {
        program {
            val cs = computeStyle {
                computeTransform = """
                        ivec2 coords = ivec2(gl_GlobalInvocationID.xy);
                        float v = cos(coords.x * 0.01 + coords.y * 0.01 + p_seconds) * 0.5 + 0.5;
                        vec4 wave = vec4(v, 0.0, 0.0, 1.0);
                        vec4 inputImagePixel = imageLoad(p_inputImg, coords);
                
                        imageStore(p_outputImg, coords, wave + inputImagePixel + p_fillColor);
                    """.trimIndent()
            }
        
            val tempBuffer = loadImage("data/images/cheeta.jpg")
            val inputBuffer = colorBuffer(width, height, type = ColorType.UINT8)
            tempBuffer.copyTo(inputBuffer)
            val outputBuffer = colorBuffer(width, height, type = ColorType.UINT8)
        
            extend {
                cs.parameter("fillColor", ColorRGBa.PINK.shade(0.1))
                cs.parameter("seconds", seconds)
                cs.image("inputImg", inputBuffer.imageBinding(0, BufferAccess.READ))
                cs.image("outputImg", outputBuffer.imageBinding(0, ImageAccess.WRITE))
                cs.execute(outputBuffer.width, outputBuffer.height, 1)
                drawer.image(outputBuffer)
            }
        }
    }
}
    