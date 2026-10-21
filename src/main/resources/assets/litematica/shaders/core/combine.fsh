#version 330
#extension GL_ARB_separate_shader_objects : require

uniform sampler2D LitematicaColorSampler;
uniform sampler2D LitematicaDepthSampler;
uniform sampler2D GameColorSampler;
uniform sampler2D GameDepthSampler;

layout(location = 0) in vec2 texCoord;
layout(location = 0) out vec4 fragColor;

void main() {
    float liteDepth = texture(LitematicaDepthSampler, texCoord).r;
    float gameDepth = texture(GameDepthSampler, texCoord).r;

    vec4 liteColor = texture(LitematicaColorSampler, texCoord);
    vec4 gameColor = texture(GameColorSampler, texCoord);

    vec4 front = liteDepth < gameDepth ? gameColor : liteColor;
    vec4 back = liteDepth < gameDepth ? liteColor : gameColor;

    float frontA = front.a;
    float backA = 1.0 - frontA; // THIS IS BAD. it should be `float backA = back.a`, but for
                                 // sky under the horizon that is 0, which makes the sky under
                                 // the horizon appear black.
                                 // other code kept here for if that ever changes

    float outA = frontA + backA * (1.0 - frontA);

    vec3 rgb = vec3(0.0);

    if (outA > 0.0) {
        rgb = (
        front.rgb * frontA +
        back.rgb * backA * (1.0 - frontA)
        ) / outA;
    }

    fragColor = vec4(rgb, outA);
}