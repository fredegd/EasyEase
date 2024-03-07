/**
* EasyEase
* A collection of easing function for Processing.
*
* https://fredegd.github.io/EasyEase/
*
* Example: setDelay
*
* This sketch demonstrates how to set the delay parameter
* 
* The delay variable determines the waiting time before 
* the curve start bending, in other words: how many 
* seconds before the motion starts
*
*
*
*
* @author      Fred Egidi  -  https://github.com/fredegd
*
*
*
*/
import easy.ease.*;
float totalLength = 2;
EasyEase curve = new EasyEase(this, 5, 2, 1, 1);
EasyEase reference = new EasyEase(this, 1, 2, 2, 0);
void setup() {
    size(600, 400);
    textSize(30);
}

void draw() {
    background(#f1f1f1);
    stroke(#ff0000);
    fill(#ff0000);
    strokeWeight(5);
    float start = 50;
    float stopX = width - 50;
    float stopY = 50;
    float motor = curve.framer(frameCount);
    float refX = constrain(mouseX, start, stopX);
    float newDelay = map(refX, start, stopX, 0, totalLength);
    
    //when calling setDelay inside of draw()
    //setSpan() should also be called to ensure the
    //motion span is tuned accordingly
    curve.setDelay(newDelay);
    curve.setSpan(totalLength - newDelay);
    
    float ptCurve_X = curve.linear(motor, start, stopX);
    float ptCurve_Y = curve.inOut(motor, height - 50, stopY);
    ellipse(ptCurve_X, ptCurve_Y, 50, 50);
    
    text("totalLength: " + curve.getTotalLength() + " sec.", 340, 300);
    text("delay:       " + String.format("%.2f", newDelay) + " sec.", 340, 350);
    
    line(start, 380, stopX, 380);
    line(refX, 370, refX, 390);
    
    line(50, 20, reference.linear(motor, start, stopX), 20);
}
