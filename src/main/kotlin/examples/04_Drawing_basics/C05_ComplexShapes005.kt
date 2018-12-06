
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.extensions.SingleScreenshot
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.compound
import org.openrndr.shape.contour
import org.openrndr.shape.shape

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            extend(ScreenRecorder()) {
                outputFile = "media/shapes-006.mp4"
                quitAfterMaximum = true
                maximumDuration = 10.0
            }
            extend {
        
                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
            
                val point = Circle(185.0, height / 2.0, 90.0).contour.position((seconds * 0.1) % 1.0)
                drawer.circle(point, 10.0)
            
                val points0 = Circle(385.0, height / 2.0, 90.0).contour.equidistantPositions(20)
                drawer.circles(points0, 10.0)
            
    
                val points1 = Circle(585.0, height / 2.0, 90.0).contour.equidistantPositions((Math.cos(seconds) * 10.0 + 30.0).toInt())
                drawer.circles(points1, 10.00)
            }
        }
    }
}
    