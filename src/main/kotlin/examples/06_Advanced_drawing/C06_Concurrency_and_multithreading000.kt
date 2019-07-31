
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
                var once = true
                extend {
                    if (once) {
                        once = false
                        launch {
                            for (i in 0 until 100) {
                                println("Hello from coroutine world ($i)")
                                delay(100)
                            }
                        }
                    }
                }
            }
        }
    }
}
    