
package examples.`06_Advanced_drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.extra.fx.blur.BoxBlur
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        val noiseShader = """
            #version 330
            // -- part of the filter interface, every filter has these
            in vec2 v_texCoord0;
            uniform sampler2D tex0;
            out vec4 o_color;
    
            // -- user parameters
            uniform float gain;
            uniform float time;
    
            #define HASHSCALE 443.8975
            vec2 hash22(vec2 p) {
                vec3 p3 = fract(vec3(p.xyx) * HASHSCALE);
                p3 += dot(p3, p3.yzx+19.19);
                return fract(vec2((p3.x + p3.y)*p3.z, (p3.x+p3.z)*p3.y));
            }
    
            void main() {
                float n = hash22(v_texCoord0+vec2(time)).x;
                // here we read from the input image and add noise
                vec4 color = texture(tex0, v_texCoord0) + vec4(vec3(n), 0.0) * gain;
                o_color = color;
            }
            """
    
        class Noise : Filter(filterShaderFromCode(noiseShader, "noise-shader")) {
            // -- note the 'by parameters' here, this is what wires the fields up to the uniforms
            var gain: Double by parameters
            var time: Double by parameters
        
            init {
                gain = 1.0
                time = 0.0
            }
        }
        program {
            // -- create the noise filter
            val noise = Noise()
            val offscreen = renderTarget(width, height) {
                colorBuffer()
                depthBuffer()
            }
        
            extend {
                // -- draw to offscreen buffer
                drawer.isolatedWithTarget(offscreen) {
                    clear(ColorRGBa.BLACK)
                    fill = ColorRGBa.PINK
                    stroke = null
                    circle(cos(seconds) * 100.0 + width / 2, sin(seconds) * 100.0 + height / 2.0, 100.0 + 100.0 * cos(seconds * 2.0))
                }
                // apply the noise on and to offscreen.colorBuffer(0),
                // this only works for filters that only read from
                // the current fragment.
                noise.time = seconds
                noise.gain = 1.0
                noise.apply(offscreen.colorBuffer(0), offscreen.colorBuffer(0))
            
                drawer.image(offscreen.colorBuffer(0))
            }
        }
    }
}
    