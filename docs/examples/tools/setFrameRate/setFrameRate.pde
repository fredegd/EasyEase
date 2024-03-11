/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set framerate
 *
 * This sketch demonstrates how to set the framerate parameter
 *
 *
 *
 *
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

EasyEase curve = new EasyEase(this, 5);

void setup() {
  size(600, 400);
  textSize(30);
  curve.setTotalLength(4);
}

void draw() {
  background(#f1f1f1);
  stroke(#ff0000);
  fill(#ff0000);
  strokeWeight(5);

  float start = 50;
  float stopX = width - 50;
  float stopY = 50;
  float motor = curve.framer(frameCount)%4;
  float refX = constrain(width-mouseX, start, stopX);
  float newFrameRate = int(map(refX, start, stopX, 2, 60));

  //when setting a different `frameRate` for the object,
  //the sketch `frameRate` should be set accordingly
  frameRate(newFrameRate);
  curve.setFrameRate(newFrameRate);

  float ptCurve_X = curve.linear(motor, start, stopX) ;
  float ptCurve_Y = curve.inOut(motor, height-50, stopY) ;

  //drawing a circle moving along the curve

  ellipse(ptCurve_X, ptCurve_Y, 50, 50 );
  //indicators
  text ("frameRate: "+String.format("%.2f", newFrameRate)+" fps.", 340, 350);
  text ("time: "+String.format("%.2f", motor)+" sec.", 340, 320);

  line(start, 380, stopX, 380);
  line(refX, 370, refX, 390);

  line(50, 20, curve.linear(motor, start, stopX), 20);
}
