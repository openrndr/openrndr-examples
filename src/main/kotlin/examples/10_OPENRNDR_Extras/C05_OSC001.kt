
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.extra.midi.MidiDeviceDescription
import org.openrndr.extra.midi.MidiTransceiver
import org.openrndr.extra.osc.OSC

fun main(args: Array<String>) {
    application {
        program {
            val osc = OSC()
        
            extend {
                osc.send("/some/address", listOf(1.0f, 2.0f))
            }
        }
    }
}
    