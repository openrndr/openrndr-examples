
package examples.`04_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.hobbyCurve
import org.openrndr.math.Vector2
import org.openrndr.math.transforms.transform
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            extend {
                val s = shape {
                    contour {
                        moveTo(Vector2(width / 2.0 - 120.0, height / 2.0 - 120.00))
                        lineTo(cursor + Vector2(240.0, 0.0))
                        lineTo(cursor + Vector2(0.0, 240.0))
                        lineTo(anchor)
                        close()
                    }
                    contour {
                        moveTo(Vector2(width / 2.0 - 80.0, height / 2.0 - 100.0))
                        lineTo(cursor + Vector2(190.0, 0.0))
                        lineTo(cursor + Vector2(0.0, 190.00))
                        lineTo(anchor)
                        close()
                    }
                }
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.shape(s)
            }
        }
    }
}
    