/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set totalLength
 *
 * This sketch demonstrates how to set the totalLength parameter of the EasyEase object.
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */
 import easy.ease.*;

EasyEase curve = new EasyEase(this, 5);
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
  float refX = constrain(width-mouseX, start, stopX);
  float newTotLength = map(refX, start, stopX, 0, 4);

  curve.setTotalLength(newTotLength);

  float ptCurve_X = curve.linear(motor, start, stopX) ;
  float ptCurve_Y = curve.inOut(motor, height-50, stopY) ;
  ellipse(ptCurve_X, ptCurve_Y, 50, 50 );

  text ("totalLength: "+String.format("%.2f", newTotLength)+" sec.", 300, 350);

  line(start, 380, stopX, 380);
  line(refX, 370, refX, 390);

  line(50, 20, curve.linear(motor, start, stopX), 20);
}
