
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
        program {
        
            var color = ColorRGBa.GRAY.shade(0.250)
            extend(ControlManager()) {
                layout {
                    button {
                        label = "click me"
                        // -- listen to the click event
                        clicked {
                            color = ColorRGBa(Math.random(), Math.random(), Math.random())
                        }
                    }
                }
            }
            extend {
                drawer.background(color)
            }
        }
    }
}
    