 /**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: Comparison_distribution Ease_inOutCirc
 *
 * Comparing the result of the easing distribution VS a linear distribution
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */

import easy.ease.*;
EasyEase curve;

float strokes = 60;

float start = 100;
float stop = 500;
void setup() {
  size(600, 600);
  curve = new EasyEase(this);
}
void draw() {
  background(0);
  strokeWeight(4);

  for (float i =0; i<=strokes; i++) {
    //linear distribution
    float linearDist = map(i, 0, strokes, start, stop);
    color linea = (frameCount)%strokes==i?#ffffff: #ff00ff;
    stroke(linea);
    line(linearDist, 50, linearDist, height/2);

    // Nonlinear distribution
    float nonLinearDist = curve.inOutCirc(i/strokes, start, stop,"once");
    color nonli = (frameCount)%strokes==i?#ffffff: #ff0000;
    stroke(nonli);
    line(nonLinearDist, height/2, nonLinearDist, height-50);
  }
}
