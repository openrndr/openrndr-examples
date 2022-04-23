#version 430
layout(local_size_x = 1, local_size_y = 1) in;

uniform vec4 fillColor;
uniform float seconds;
layout(rgba8) uniform readonly image2D inputImg;
uniform writeonly image2D outputImg;

void main() {
    ivec2 coords = ivec2(gl_GlobalInvocationID.xy);
    float v = cos(coords.x * 0.01 + coords.y * 0.01 + seconds) * 0.5 + 0.5;
    vec4 wave = vec4(v, 0.0, 0.0, 1.0);
    vec4 inputImagePixel = imageLoad(inputImg, coords);

    imageStore(outputImg, coords, wave + inputImagePixel + fillColor);
}
