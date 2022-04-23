
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineJoin
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend {
                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                // -- shape union
                val su = compound {
                    union {
                        shape(Circle(185.0, height / 2.0 - 80.0, 100.0).shape)
                        shape(Circle(185.0, height / 2.0 + 80.0, 100.0).shape)
                    }
                }
                drawer.shapes(su)
            
                // -- shape difference
                val sd = compound {
                    difference {
                        shape(Circle(385.0, height / 2.0 - 80.0, 100.0).shape)
                        shape(Circle(385.0, height / 2.0 + 80.0, 100.0).shape)
                    }
                }
                drawer.shapes(sd)
            
                // -- shape intersection
                val si = compound {
                    intersection {
                        shape(Circle(585.0, height / 2.0 - 80.0, 100.0).shape)
                        shape(Circle(585.0, height / 2.0 + 80.0, 100.0).shape)
                    }
                }
                drawer.shapes(si)
            }
        }
    }
}
    