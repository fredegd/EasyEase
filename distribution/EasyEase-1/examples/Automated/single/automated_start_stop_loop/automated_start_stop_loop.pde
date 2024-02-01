 /**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: automated start_stop_loop
 * 
 * automate the motion from the  start 
 * to the stop value.
 * 
 * the result motion loops from the  start 
 * to the stop value.
 * 
 * @author      Fred Egidi  https://fredegd.dev/
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

  float x = mover.out(start, stop, "loop");

  rect(x, height/2, 100, 100);
}
