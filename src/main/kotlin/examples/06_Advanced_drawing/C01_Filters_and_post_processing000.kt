
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Filter
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.isolatedWithTarget
import org.openrndr.draw.renderTarget
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.filter.blur.BoxBlur
import org.openrndr.filter.filterShaderFromCode

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 578
        }
        program {
            // -- create offscreen render target
            val offscreen = renderTarget(width, height) {
                colorBuffer()
                depthBuffer()
            }
            // -- create blur filter
            val blur = BoxBlur()
        
            // -- create colorbuffer to hold blur results
            val blurred = colorBuffer(width, height)
            extend(ScreenRecorder()) {
                frameRate = 60
                maximumDuration = 10.00
                quitAfterMaximum = true
                outputFile = "media/filters-001.mp4"
            }
        
            extend {
                // -- draw to offscreen buffer
                drawer.isolatedWithTarget(offscreen) {
                    background(ColorRGBa.BLACK)
                    fill = ColorRGBa.PINK
                    stroke = null
                    circle(Math.cos(seconds) * 100.0 + width / 2, Math.sin(seconds) * 100.0 + height / 2.0, 100.0 + 100.0 * Math.cos(seconds * 2.0))
                }
                // -- set blur parameters
                blur.window = 30
            
                // -- blur offscreen's color buffer into blurred
                blur.apply(offscreen.colorBuffer(0), blurred)
                drawer.image(blurred)
            }
        }
    }
}
    