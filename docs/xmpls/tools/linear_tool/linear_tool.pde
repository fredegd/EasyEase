/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: ease_In_method
 *
 * automate the motion from 0 to 1
 * taking the frameCount as a motion controller
 *
 * the result motion cycles from 0 to 1
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 *
 */
import easy.ease.*;

float intensity = 4.0;
float totalLength = 2;
float span = 1.5;
float delay = 0.25;
EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  curve.setTotalLength(totalLength);
  //curve.setSpan(span);
  //curve.setDelay(delay);
}

void draw() {
  background(#f1f1f1);
  fill(#ff0000);
  
  float mot_counter = curve.framer(frameCount);
  float x = curve.linear(mot_counter ) * (width) -50;
  rect(x, 0, 100, width);
  rec(30,120);
}
