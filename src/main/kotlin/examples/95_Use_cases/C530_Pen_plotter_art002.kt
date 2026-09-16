
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
            // Instantiate Plot specifying the paper size in millimeters.
            val plot = Plot(
                dimensions = Vector2(148.0, 210.0), // A5 Portrait
                manualRedraw = false,
                origin = Origin.CENTER
            )
    
            extend(plot) {
                generator = BasicGrblGenerator()
                layerMode = LayerMode.SINGLE_FILE
                folder = "/tmp"
            }
    
            // A function to draw concentric circles into a layer
            // with a unique name.
            fun addCircles(pos: Vector2) {
                plot.layer("layer_${plot.layers.size}") {
                    strokeWeight = 0.5
                    repeat(15) {
                        circle(pos, 1.0 + it * it)
                    }
                }
            }
    
            // Generate a new design every time we click the mouse
            mouse.buttonDown.listen {
                addCircles(plot.toDocumentSpace(it.position))
            }
            run {
                addCircles(plot.docBounds.position(0.2, 0.2))
                addCircles(plot.docBounds.position(0.8, 0.8))
            }
            keyboard.keyDown.listen {
                // Clear the design when pressing the `c` key
                if (it.name == "c") {
                    plot.layers.clear()
                }
                // Press "g" to export G-code to /tmp.
                // (implemented by Plot)
            }
        }
    }
}
    