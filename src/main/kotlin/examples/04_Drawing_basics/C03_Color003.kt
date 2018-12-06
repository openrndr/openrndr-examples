
package examples.`04_Drawing_basics`

import org.openrndr.application
import org.openrndr.color.*
import org.openrndr.extensions.SingleScreenshot

fun main(args: Array<String>) {
    application {
        configure {
            width = 770
            height = 672
        }
        program {
            extend(SingleScreenshot()) {
                outputFile = "media/color-004.png"
            }
            extend {
                drawer.stroke = null
            
                // -- draw hsv swatches
                for (j in 0..7) {
                    for (i in 0..31) {
                        drawer.fill = ColorHSVa(360 * (i / 31.0), 0.7, 0.125 + j / 8.0).toRGBa()
                        drawer.rectangle(35.0 + (700 / 32.0) * i, 32.0 + j * 16.0, (700 / 32.0), 16.0)
                    }
                }
            
                // -- draw hsl swatches
                drawer.translate(0.0, 160.0)
                for (j in 0..7) {
                    for (i in 0..31) {
                        drawer.fill = ColorHSLa(360 * (i / 31.0), 0.7, 0.125 + j / 9.0).toRGBa()
                        drawer.rectangle(35.0 + (700 / 32.0) * i, 32.0 + j * 16.0, (700 / 32.0), 16.0)
                    }
                }
            
                // -- draw xsv (Kuler) swatches
                drawer.translate(0.0, 160.0)
                for (j in 0..7) {
                    for (i in 0..31) {
                        drawer.fill = ColorXSVa(360 * (i / 31.0), 0.7, 0.125 + j / 8.0).toRGBa()
                        drawer.rectangle(35.0 + (700 / 32.0) * i, 32.0 + j * 16.0, (700 / 32.0), 16.0)
                    }
                }
            
                // -- draw xsl (Kuler) swatches
                drawer.translate(0.0, 160.0)
                for (j in 0..7) {
                    for (i in 0..31) {
                        drawer.fill = ColorXSLa(360 * (i / 31.0), 0.7, 0.125 + j / 9.0, 1.0).toRGBa()
                        drawer.rectangle(35.0 + (700 / 32.0) * i, 32.0 + j * 16.0, (700 / 32.0), 16.00)
                    }
                }
            }
        }
    }
}
    