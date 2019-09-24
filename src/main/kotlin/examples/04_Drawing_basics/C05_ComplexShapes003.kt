
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.compound
import org.openrndr.shape.contour
import org.openrndr.shape.shape

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                val cross = compound {
                    union {
                        intersection {
                            shape(Circle(width / 2.0 - 160.0, height / 2.0, 200.0).shape)
                            shape(Circle(width / 2.0 + 160.0, height / 2.0, 200.0).shape)
                        }
                        intersection {
                            shape(Circle(width / 2.0, height / 2.0 - 160.0, 200.0).shape)
                            shape(Circle(width / 2.0, height / 2.0 + 160.0, 200.0).shape)
                        }
                    }
                }
                drawer.shapes(cross)
            }
        }
    }
}
    