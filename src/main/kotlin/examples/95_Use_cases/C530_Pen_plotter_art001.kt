
package examples.`95_Use_cases`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.dialogs.saveFileDialog
import org.openrndr.extra.axidraw.Axidraw
import org.openrndr.extra.axidraw.PaperSize
import org.openrndr.extra.composition.composition
import org.openrndr.extra.composition.draw
import org.openrndr.extra.composition.drawComposition
import org.openrndr.extra.gcode.BasicGrblGenerator
import org.openrndr.extra.gcode.LayerMode
import org.openrndr.extra.gcode.Origin
import org.openrndr.extra.gcode.Plot
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.noise.uniform
import org.openrndr.extra.svg.saveToFile
import org.openrndr.math.Vector2
import java.io.File

fun main() {
    application {
        program {
            // Instantiate orx-axidraw specifying the paper size in portrait mode.
            // Use `PaperSize.A5.size.yx` for landscape mode, or provide custom paper sizes
            // as a Vector2 in millimeters.
            val axi = Axidraw(this, PaperSize.A5.size)
    
            // Create a GUI and add the the controls provided by orx-axidraw
            val gui = GUI()
            gui.add(axi)
    
            // A function to draw concentric circles into the composition.
            fun addCircles(pos: Vector2) {
                axi.draw {
                    repeat(15) {
                        circle(pos, 1.0 + it * it)
                    }
                }
            }
    
            // Activate the GUI
            extend(gui)
            extend {
                drawer.clear(ColorRGBa.WHITE)
                // Draw the design held by orx-axidraw on the program window
                axi.display(drawer)
            }
    
            // Generate a new design every time we click the mouse
            mouse.buttonDown.listen {
                addCircles(it.position)
            }
            keyboard.keyDown.listen {
                // Clear the design when pressing the `c` key
                if (it.name == "c") {
                    axi.clear()
                }
                // No need to add a saving option here:
                // orx-axidraw adds saving and loading GUI buttons by default
            }
        }
    }
}
    