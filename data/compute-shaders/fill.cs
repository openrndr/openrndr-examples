#version 430
layout(local_size_x = 1, local_size_y = 1) in;
uniform writeonly image2D outputImg;
uniform vec4 fill;

layout(rgba8) uniform readonly image2D inputImg;
void main() {
    ivec2 coords = ivec2(gl_GlobalInvocationID.xy);
    float v = cos(coords.x*0.01 + coords.y*0.01)*0.5+0.5;

    vec4 inxel = imageLoad(inputImg, coords);
    vec4 pixel = vec4(v, 0.0, 0.0, 1.0);
    imageStore(outputImg, coords, pixel+inxel+fill);
}