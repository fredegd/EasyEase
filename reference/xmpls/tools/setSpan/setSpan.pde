/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set span
 *
 * This sketch demonstrates how to set the span of the motion.
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */
 
 import easy.ease.*;

EasyEase curve = new EasyEase(this, 5);
EasyEase reference = new EasyEase(this, 1, 2, 2, 0);

void setup() {
  size(600, 400);
  textSize(30);
  curve.setTotalLength(2.0);
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
  float newSpan = map(refX, 0, width, 0, 2);

  curve.setSpan(newSpan);

  float ptCurve_X = curve.linear(motor, start, stopX) ;
  float ptCurve_Y = curve.inOut(motor, height-50, stopY) ;
  ellipse(ptCurve_X, ptCurve_Y, 50, 50 );

  text ("totalLength: "+curve.getTotalLength()+" sec.", 300, 300);
  text ("motion span: "+String.format("%.2f", newSpan)+" sec.", 300, 350);

  line(start, 380, stopX, 380);
  line(refX, 370, refX, 390);

  line(50, 20, reference.linear(motor, start, stopX), 20);
  rec(30,900);
}
