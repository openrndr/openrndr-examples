
package examples.`07_Interaction`

import org.openrndr.KEY_ARROW_LEFT
import org.openrndr.KEY_BACKSPACE
import org.openrndr.KeyboardModifier
import org.openrndr.application

fun main(args: Array<String>) {
    application {
        program {
            mouse.moved.listen {
                // -- it refers to a MouseEvent instance here
                println(it.position)
            }
            mouse.buttonDown.listen {
            }
        }
    }
}
    