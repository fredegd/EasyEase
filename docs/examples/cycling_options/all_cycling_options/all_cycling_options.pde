/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: once
 *
 * automate the motion from start to stop
 * taking a conter as a motion controller
 *
 * the motion cycles only once
 *
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 *
 */
import easy.ease.*;

float intensity = 3.0;
EasyEase curve = new EasyEase(this, intensity);

void setup() {
  size(600, 600);
  rectMode(CENTER);
}
void draw() {
  background(0);
  fill(255, 0, 255);
  noStroke();

  float count = curve.framer(frameCount);

  float start = 50;
  float stop = width-50;

  float x1 = curve.out(count, start, stop, "once");
  float x2 = curve.out(count, start, stop, "loop");
  float x3 = curve.out(count, start, stop, "alternate");
  
  rect(x1, 150, 100, 100);
  rect(x2, 300, 100, 100);
  rect(x3, 450, 100, 100);
}
