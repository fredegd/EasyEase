/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: controlled start_stop_loop
 *
 * automate the motion looping from
 * the  start to the stop value
 * taking a conter as a motion controller
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

  float x = curve.out(count, start, stop, "loop");
  
  //alternatively, omitting the option parameter,
  //it return the same result since "loop" is the default
  
  //float x = curve.out(count, start, stop);
  
  rect(x, height/2, 100, 100);
}
