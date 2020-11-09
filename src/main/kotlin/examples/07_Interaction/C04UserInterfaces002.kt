
package examples.`07_Interaction`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.panel.ControlManager
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.layout
import org.openrndr.panel.style.*
import org.openrndr.panel.styleSheet

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 45
        }
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
    