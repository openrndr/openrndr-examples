
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
            // Generate a list containing values between 0.0 and 1.0
            val x = List(width) { it.toDouble() / width }
    
            // Filter out high `x` values.
            // The condition is likely to be false for high `it` values, making them fail the test.
            val filtered = x.filter { Math.random() > it }
    
            // Map the lucky Double values to LineSegment instances.
            // `segs` is a `List<LineSegment>` and `it` is the current list element being processed (a double).
            val segs = filtered.map {
                LineSegment(it * width, 0.0, it * width, height.toDouble())
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.stroke = ColorRGBa.PINK
                // Draw the line segments in our list
                drawer.lineSegments(segs)
            }
        }
    }
}
    