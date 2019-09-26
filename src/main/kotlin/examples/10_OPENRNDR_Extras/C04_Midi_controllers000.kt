
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.extra.midi.MidiDeviceDescription
import org.openrndr.extra.midi.MidiTransceiver

fun main(args: Array<String>) {
    application {
        program {
            MidiDeviceDescription.list().forEach {
                println("name: '${it.name}', vendor: '${it.vendor}', receiver:${it.receive}, transmitter:${it.transmit}")
            }
        }
    }
}
    