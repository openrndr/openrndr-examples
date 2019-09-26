
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.extra.midi.MidiDeviceDescription
import org.openrndr.extra.midi.MidiTransceiver

fun main(args: Array<String>) {
    application {
        program {
            val controller = MidiTransceiver.fromDeviceVendor("BCR2000 [hw:2,0,0]", "ALSA (http://www.alsa-project.org)")
        }
    }
}
    