
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.shape.*

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                val composition = drawComposition {
                    fill = ColorRGBa.PINK
                    stroke = null
                    // -- shape union
                    shape(union(
                        Circle(185.0, height / 2.0 - 80.0, 100.0).shape,
                        Circle(185.0, height / 2.0 + 80.0, 100.0).shape
                    ))

                    // -- shape difference
                    shape(difference(
                        Circle(385.0, height / 2.0 - 80.0, 100.0).shape,
                        Circle(385.0, height / 2.0 + 80.0, 100.0).shape
                    ))

                    // -- shape intersection
                    shape(intersection(
                        Circle(585.0, height / 2.0 - 80.0, 100.0).shape,
                        Circle(585.0, height / 2.0 + 80.0, 100.0).shape
                    ))
                }

                drawer.composition(composition)
            }
        }
    }
}
    