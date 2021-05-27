
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.ColorType
import org.openrndr.draw.loadImage
import org.openrndr.extra.compositor.*
import org.openrndr.extra.jumpfill.DistanceField
import org.openrndr.extra.jumpfill.fx.InnerGlow
import org.openrndr.extra.jumpfill.fx.OuterGlow
import org.openrndr.ffmpeg.ScreenRecorder
import kotlin.math.PI
import kotlin.math.cos

fun main(args: Array<String>) {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
        
            val c = compose {
                layer {
                    colorType = ColorType.FLOAT32
                
                    draw {
                        drawer.image(image)
                    }
                    post(DistanceField()) {
                        threshold = cos(seconds * PI * 0.25) * 0.5 + 0.5
                        distanceScale = 0.008
                    }
                }
            }
            extend {
                c.draw(drawer)
            }
        }
    }
}
    