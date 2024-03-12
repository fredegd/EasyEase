/**
* EasyEase
* A collection of easing function for Processing.
*
* https://fredegd.github.io/EasyEase/
*
* Example: delay modulation
*
* this example explains how to set
* custom delay span and totalLength for
* an animation / distribution
*
* move the mouse left - right to
* add 0 - 2 seconds of delay
*
* @author      Fred Egidi  -  https://github.com/fredegd
*/

import easy.ease.*;

EasyEase curve;
float totalLength = 2;
float delay = 0.0;
float span = totalLength;
float bgCol = 0;
void setup() {
    
    size(600, 600);
    curve = new EasyEase(this, 3, totalLength, span, delay);
    //this option deactivate the settings log
    curve.setLog(false);
}

void draw() {
    background(bgCol);
    noFill();
    strokeWeight(3);
    //combining the mouseX values and both
    //methods .setDelay(float) and  setSpan(float)
    //to modulate the curve's span and delay
    float del = map(mouseX, 0, width, 0, totalLength);
    curve.setSpan(totalLength - del);
    curve.setDelay(del);
    //
    //the .framer(float) method is useful to divide
    //an incremental value to the Sketch framerate
    float motor = curve.framer(frameCount);
    
    //
    //updating the bg color by applying the curve
    bgCol = curve.inOut(motor, 0, 255, "loop");
    //
    //some graphic indicators
    float statInd = curve.inOut(motor, height - 50, 50, "loop");
    float motInd = width - map(motor, 0, totalLength, width / 2, width * 1.5) % width;
    stroke(255, 0, 0);
    line(0, statInd, width, statInd);
    ellipse(width / 2, statInd, 15, 15);
    line(motInd, 0, motInd, height);
    //
    //drawing the curve as a shape
    stroke(0, 255, 0);
    beginShape();
    for (float i = 0; i < totalLength; i += (totalLength / 60.0)) {
        float shapeMotor = (i + motor - totalLength / 2);
        float x = map(i, 0, totalLength, 0, width);
        float y = curve.inOut(shapeMotor, height - 50, 50, "loop");
        vertex(x, y);
}
    endShape();
}
