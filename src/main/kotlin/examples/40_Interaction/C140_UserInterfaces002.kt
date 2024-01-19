
package examples.`40_Interaction`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.ControlManager
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.layout
import org.openrndr.panel.style.*
import org.openrndr.panel.styleSheet

fun main() {
    application {
        program {
            extend(ControlManager()) {
                layout {
                    button {
                        label = "Click me "
                        events.clicked.listen {// -- do something with the clicked event
                        }
                    }
                }
            }
            extend {
                drawer.clear(ColorRGBa.GRAY.shade(0.250))
            }
        }
    }
}
    