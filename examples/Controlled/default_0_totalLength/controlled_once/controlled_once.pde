 /**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: controlled_once
 * 
 * automate the motion from 0 to 1 
 * taking a conter as a motion controller
 * 
 * the result motion happens only once
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */
 
 import easy.ease.*;
EasyEase mover;
float intensity = 3.0;
void setup() {
  size(600, 600);
  rectMode(CENTER);
  mover = new EasyEase(this,intensity);
}
void draw() {
  background(0);
  fill(255, 0, 255);
  noStroke();
  float count = frameCount/60.0;
  //alternatively:
  //float count = mover.framer(frameCount);
  float x = mover.out(count,"once")*width;
  rect(x, height/2, 100, 100);
}
