/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Ease_outSine
 *
 * Calculates an ease-out Sine curve interpolation which starts slowly and progressively speeds up.
 * 
 * the interpolated value is the passed to a rectangle to move it from left to right. 
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

float intensity = 4.0;
float totalLength = 2;
float span = 1.5;
float delay = 0.25;
EasyEase curve = new EasyEase(this, intensity, totalLength, span, delay);

void setup() {
  size(600, 400);
}

void draw() {
  background(#f1f1f1);
  fill(#ff0000);

  float mot_counter = curve.framer(frameCount);
  float x = curve.outSine(mot_counter ) * (width-100);
  rect(x, 0, 100, width);
}