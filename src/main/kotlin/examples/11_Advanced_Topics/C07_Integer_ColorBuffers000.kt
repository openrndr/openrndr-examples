
package examples.`11_Advanced_Topics`

import org.openrndr.application
import org.openrndr.draw.*
import java.nio.ByteBuffer

fun main() = application {
    configure {
        width = 640
        height = 480
    }
    program {
        val magicNumber: Byte = 42
        // 1x1-pixel buffer holding one unsigned short / uint16 value
        val intColorBuffer = colorBuffer(
            1,
            1,
            format = ColorFormat.R,
            type = ColorType.UINT16_INT
        )

        // the following line is crucial, non-nearest filtering will result in
        // sampling texels always equal to 0 in shaders
        intColorBuffer.filter(MinifyingFilter.NEAREST, MagnifyingFilter.NEAREST)

        // standard color buffer to match the output window size, with ColorType.UINT8
        // by default, which is still sampled as floating point number in shaders
        val imageColorBuffer = colorBuffer(width, height)

        // fragment shader to transform integer data into something visible
        // if input is matching the magic number, we are outputting whiteness
        // usampler2D is used for unsigned integer values
        val intInputRenderer = Filter(
            Shader.createFromCode(
                fsCode = """
                    #version 330
                    
                    uniform usampler2D tex0;
                    out     vec4 color;

                    const uint EXPECTED_VALUE = uint($magicNumber);

                    void main() {
                        uvec4 texel = texelFetch(tex0, ivec2(0), 0);
                        color = vec4(
                            vec3((texel.r == EXPECTED_VALUE) ? 1.0 : 0.0),
                            1.0
                        );
                    }
                """.trimIndent(),
                vsCode = Filter.filterVertexCode,
                name = "shader with usampler2D as input"
            )
        )

        // in the same example we are also testing texture write / read
        val inData = ByteBuffer.allocateDirect(2) // 2 because we are storing shorts
        val outData = ByteBuffer.allocateDirect(2)
        inData.rewind()
        inData.put(magicNumber)
        inData.put(0)
        inData.rewind()
        intColorBuffer.write(inData)
        outData.rewind()
        intColorBuffer.read(outData)
        outData.rewind()
        println("outData should contain $magicNumber, is: ${outData.short}")
        extend {
            intInputRenderer.apply(intColorBuffer, imageColorBuffer)
            drawer.image(imageColorBuffer, 0.0, 0.0, width.toDouble(), height.toDouble())
        }
    }
}
