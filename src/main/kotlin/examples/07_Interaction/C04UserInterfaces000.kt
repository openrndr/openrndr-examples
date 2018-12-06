
package examples.`07_Interaction`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.controlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.style.*

fun main(args: Array<String>) {
    application {
        program {
            var color = ColorRGBa.WHITE
            val cm = controlManager {
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
            extend(cm) // <- this registers the control manager as a Program Extension
        }
    }
}
    