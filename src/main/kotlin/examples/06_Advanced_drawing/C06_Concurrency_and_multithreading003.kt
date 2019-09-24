
package examples.`06_Advanced_drawing`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.draw.colorBuffer

import org.openrndr.internal.finish
import org.openrndr.launch
import java.nio.ByteBuffer
import kotlin.random.Random

fun main(args: Array<String>) {
    run {
        application {
            program {
                val result = colorBuffer(512, 512)
                var once = true
                var done = false
                val secondary = drawThread()
            
                extend {
                    if (once) {
                        once = false
                    
                        // -- launch on the secondary draw thread (SDT)
                        secondary.launch {
                            // -- create a render target on the SDT.
                            val rt = renderTarget(512, 512) {
                                colorBuffer(result)
                            }
                        
                            // -- make sure we use the draw thread's drawer
                            val drawer = secondary.drawer
                            drawer.withTarget(rt) {
                                drawer.ortho(rt)
                                drawer.background(ColorRGBa.PINK)
                            }
                        
                            // -- destroy the render target
                            rt.destroy()
                            finish()
                            // -- tell main thread the work is done
                            done = true
                        }
                    }
                    // -- draw the result when the work is done
                    if (done) {
                        drawer.image(result)
                    }
                }
            }
        }
    }
}
    