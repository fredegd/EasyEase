/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://github.com/fredegd/EasyEase
 *
 * Example: automated start_stop_once
 *
 * automate the motion from the  start
 * to the stop value.
 *
 * the motion only happen once
 *
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 *
 */





import easy.ease.*;
EasyEase mover;
float intensity = 3.0;
void setup() {
  size(600, 600);
  rectMode(CENTER);
  mover = new EasyEase(this, intensity);
}
void draw() {
  background(0);
  fill(255, 0, 255);
  noStroke();

  float start = 50;
  float stop = width-50;

  float x = mover.out(start, stop, "once");

  rect(x, height/2, 100, 100);
}