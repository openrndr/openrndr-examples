
package examples.`04_Drawing_basics`.`05_text`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle
import org.openrndr.text.Writer

fun main(args: Array<String>) {
    application {
        configure {
            width = 640
            height = 480
        }
        program {
            extend(ScreenRecorder().apply {
                maximumDuration = 5.0
                outputFile = "media/text-002.mp4"
            })
            extend {
                drawer.background(ColorRGBa.PINK)
            
                // -- First create a new Writer object.
                // -- The writer needs a reference to the drawer in order to match style and transforms.
                val writer = Writer(drawer)
            
                // -- Set a font, this is a required step
                drawer.fontMap = FontImageMap.fromUrl("file:fonts/iosevka-custom-medium.ttf", 20.0)
                drawer.stroke = null
                drawer.fill = ColorRGBa.WHITE
            
                // -- Setup a 400 by 400 pixel text box at position 100, 100
                writer.box = Rectangle(Vector2(100.0, 100.0), 400.0, 400.0)
            
                // -- Output some text
                writer.text("Some text")
            
                // -- Go to the next line and output more text
                writer.newLine()
                writer.text("Some more text man2!")
            }
        }
    }
}
    