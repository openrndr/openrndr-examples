
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
            // A list containing 1.0, 2.0, 5.0, 10.0, 17.0 ...
            val radii = List(20) { i -> 1.0 + i * i }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.stroke = ColorRGBa.PINK
                // Go over each radius in the list and use it
                // for the stroke weight and the radius of a circle
                radii.forEach { radius ->
                    drawer.strokeWeight = radius * 0.1
                    drawer.circle(drawer.bounds.center, radius)
                }
            }
        }
    }
}
    