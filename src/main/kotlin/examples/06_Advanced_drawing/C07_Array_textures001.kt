
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
                val colorBuffer = colorBuffer(512, 512)
                val data = ByteBuffer.allocateDirect(512 * 512 * 4)
                var once = true
                extend {
                    if (once) {
                        once = false
                        launch {
                            // -- launch on GlobalScope
                            // -- this will cause the coroutine to be executed off-thread.
                            GlobalScope.launch {
                                // -- perform some faux-heavy calculations
                                val r = Random(100)
                                for (y in 0 until 512) {
                                    for (x in 0 until 512) {
                                        for (c in 0 until 4) {
                                            data.put(r.nextBytes(1)[0])
                                        }
                                    }
                                }
                            }.join() // -- wait for coroutine to complete
                        
                            // -- write data to graphics resources
                            data.rewind()
                            colorBuffer.write(data)
                        }
                    }
                }
            }
        }
    }
}
    