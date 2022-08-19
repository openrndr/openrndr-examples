
package examples.`07_Interaction`

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
                styleSheet(has type "button") {
                    background = Color.RGBa(ColorRGBa.PINK)
                    color = Color.RGBa(ColorRGBa.BLACK)
                }
            
                layout {
                    button {
                        label = "click me"
                    }
                }
            }
        }
    }
}
    