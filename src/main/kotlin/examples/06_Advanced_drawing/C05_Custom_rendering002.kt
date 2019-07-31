
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.math.Vector3
import org.openrndr.math.transforms.transform

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend(SingleScreenshot()) {
                outputFile = "media/custom-rendering-003.png"
                multisample = BufferMultisample.SampleCount(8)
            }
            // -- create the vertex buffer
            val geometry = vertexBuffer(vertexFormat {
                position(3)
            }, 4)
        
            // -- fill the vertex buffer with vertices for a unit quad
            geometry.put {
                write(Vector3(-1.0, -1.0, 0.0))
                write(Vector3(-1.0, 1.0, 0.0))
                write(Vector3(1.0, -1.0, 0.0))
                write(Vector3(1.0, 1.0, 0.0))
            }
        
            // -- create the secondary vertex buffer, which will hold transformations
            val transforms = vertexBuffer(vertexFormat {
                attribute("transform", VertexElementType.MATRIX44_FLOAT32)
            }, 1000)
        
            // -- fill the transform buffer
            transforms.put {
                for (i in 0 until 1000) {
                    write(transform {
                        translate(Math.random() * width, Math.random() * height)
                        rotate(Vector3.UNIT_Z, Math.random() * 360.0)
                        scale(Math.random() * 30.0)
                    })
                }
            }
            extend {
                drawer.fill = ColorRGBa.PINK.opacify(0.25)
                drawer.shadeStyle = shadeStyle {
                    vertexTransform = "x_viewMatrix = x_viewMatrix * i_transform;"
                }
                drawer.vertexBufferInstances(listOf(geometry), listOf(transforms), DrawPrimitive.TRIANGLE_STRIP, 1000)
            }
        }
    }
}
    