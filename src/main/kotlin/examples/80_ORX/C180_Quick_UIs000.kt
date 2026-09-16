
package examples.`80_ORX`

import jdk.jfr.Description
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.BlendMode
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.isolatedWithTarget
import org.openrndr.draw.renderTarget
import org.openrndr.extra.color.presets.DARK_BLUE
import org.openrndr.extra.color.presets.DARK_ORCHID
import org.openrndr.extra.compositor.*
import org.openrndr.extra.fx.blend.Multiply
import org.openrndr.extra.fx.blur.ApproximateGaussianBlur
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.gui.GUIAppearance
import org.openrndr.extra.gui.WindowedGUI
import org.openrndr.extra.gui.addTo
import org.openrndr.extra.parameters.*
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import org.openrndr.panel.collections.SelectableList
import org.openrndr.panel.collections.SelectableMutableList
import org.openrndr.panel.style.Color
import org.openrndr.panel.style.defaultStyles
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
    
        program {
            val gui = GUI()
            extend(gui)
        }
    }
}
    