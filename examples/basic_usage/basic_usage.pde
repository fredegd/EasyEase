/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Basic Usage
 *
 * Comparing the result of the easing distribution VS a linear distribution
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */
 import easy.ease.*;

float intensity = 9.2;
EasyEase  curve = new EasyEase(this, intensity);

void setup() {
  size(600, 400);
}
void draw() {
  float start = 100;
  float stop = 400;
  float framedCount = curve.framer(frameCount*0.5);

  float x = curve.inOut(framedCount,start, stop);
  float y = curve.linear(framedCount,0, height-100);

  fill(255, 0, 0);
  rect(x, y, 100,100);
}
