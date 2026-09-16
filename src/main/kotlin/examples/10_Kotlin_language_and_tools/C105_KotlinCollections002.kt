
package examples.`10_Kotlin_language_and_tools`

import org.intellij.lang.annotations.Language
import org.openrndr.application
import org.openrndr.color.ColorHSVa
import org.openrndr.color.ColorRGBa
import org.openrndr.math.Vector2
import org.openrndr.shape.LineSegment

fun main() {
    application {
        program {
            // Notice how we can specify the key and value types
            val data = mutableMapOf<Vector2, ColorRGBa>()
            // Populate the map with 10 positions and colors
            repeat(10) {
                val pos = Vector2(60.0 + 50.0 * it, height * 0.5)
                val color = ColorHSVa(it * 36.0, 0.7, 1.0).toRGBa()
                data[pos] = color
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                // Iterate over all the map items using the position and color of each
                data.forEach { (pos, c) ->
                    drawer.fill = c
                    drawer.circle(pos, 50.0)
                }
            }
        }
    }
}
    