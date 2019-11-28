
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.extra.midi.MidiDeviceDescription
import org.openrndr.extra.midi.MidiTransceiver
import org.openrndr.extra.osc.OSC

fun main(args: Array<String>) {
    application {
    
        program {
            val osc = OSC()
            osc.listen("/live/track/2") { it ->
                // -- get the first value
                val firstValue = it[0] as Float
            }
            extend {
            }
        }
    }
}
    