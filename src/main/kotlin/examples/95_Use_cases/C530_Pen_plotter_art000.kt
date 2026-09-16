
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
            // Create an empty composition
            val design = drawComposition { }
    
            // A function to draw concentric circles into the composition.
            fun addCircles(pos: Vector2) {
                design.draw {
                    repeat(15) {
                        circle(pos, 1.0 + it * it)
                    }
                }
            }
    
            // Draw the composition onto the window
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.composition(design)
            }
    
            // Generate a new design every time we click the mouse
            mouse.buttonDown.listen {
                addCircles(it.position)
            }
            keyboard.keyDown.listen {
                // Clear the design when pressing the `c` key
                if (it.name == "c") {
                    design.clear()
                }
                // Show a save dialog when pressing the `s` key, then save the design
                // with the chosen file name into the selected folder.
                if (it.name == "s") {
                    saveFileDialog(supportedExtensions = listOf("SVG" to listOf("svg"))) { file ->
                        design.saveToFile(file)
                    }
                }
            }
        }
    }
}
    