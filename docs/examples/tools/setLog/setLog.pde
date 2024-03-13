/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set intensity
 *
 * This sketch demonstrates how to set the intensity parameter
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


EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  curve.setLog(false);
  // the following setter function won't return any log
  curve.setIntensity(4.2);
  curve.setTotalLength(6);
  curve.setDelay(2);
  curve.setSpan(1);
}

void draw() {
  float mot_counter = curve.framer(frameCount);
  float x = curve.inBounce(mot_counter ) * (width-100);
  background(#f1f1f1);
  fill(#ff0000);
  rect(x, 0, 100, width);
}
