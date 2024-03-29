/**
* EasyEase
* A collection of easing function for Processing.
* https://fredegd.github.io/EasyEase/-Processing-Library
*
* Example: Array_Grid
*
* This sketch demonstrate how to initialize an array of
* EasyEase Objects passing totalLength, animationSpan, delay
* as parameters
*
* since each element receives a different delay value,
* when placed in a grid, for example it produces  very
* interesting motion effects
*
* the "alternate" option ensures
* the result motion cummutes back and forth
* from the  start to the stop value.
*
* @author      Fred Egidi  -  https://github.com/fredegd
*/

import easy.ease.*;

int base = 1;
int elements = base * base;
float ts = 900.0 / base;

float totalLength  = 4;
float animationSpan = 2;
float expVal = 14;
float col;

EasyEase[]  easyease = new EasyEase[elements];

void setup() {
    size(900, 900, P3D);
    rectMode(CENTER);
    for (int i = 0; i < elements; i++) {
        float delayMap = map(i, 0, elements, 0, animationSpan / 2);
        easyease[i] = new EasyEase(this, expVal, totalLength, animationSpan, delayMap);
}
}

void draw() {
    background(0);
    noStroke();
    for (int i = 0; i < elements; i++) {
        float x = i % base * ts + ts / 2;
        float y = floor(i / base) * ts + ts / 2;
        
        //float motor = easyease[0].framer(frameCount+(x+y)*0.1);
        float motor = easyease[0].framer(frameCount);
        float mot1 = easyease[i].inOut(motor, 0.0, 1.0, "alternate");
        float mot2 = easyease[i].inOutBack(2 * motor, "alternate") * ts / 4 - ts / 8;
        
        float rectW = map(mot1, 0, 1, ts * 0.75, ts * 0.25) + mot2;
        float rectH = map(mot1, 0, 1, ts * 0.25, ts * 0.75) + mot2;
        
        col = (map(mot2, -ts / 8, ts / 8, 0, 255));
        
        push();
        translate(x, y, mot2);
        rotateY(mot1 * PI);
        rotate((mot2 / (ts * 0.25)) * HALF_PI - QUARTER_PI);
        
        fill(255 - mot1 * 255, col, 255 - col);
        rect(0, 0, rectW, rectH);
        pop();
}
}
