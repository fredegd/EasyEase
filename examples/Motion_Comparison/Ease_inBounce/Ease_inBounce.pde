/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Motion-Comparison Ease_inBounce
 *
 * Comparing the result of the easing motion VS a linear Motion
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */

import easy.ease.*;
EasyEase curve;
float iStep = 1.0/60.0;
float intensity =2;
float totalLength = 2;
void setup() {
  size(600, 600);
  textSize(30);
  rectMode(CENTER);
  textAlign(CENTER,CENTER);
  curve = new EasyEase(this, intensity);
  //set the total lenght of the motion, (in seconds)
  curve.setTotalLength(totalLength);
}
void draw() {
  float start = 50;
  float stop = width-50;

  float counter = curve.framer(frameCount)%totalLength;
  float nonLinear= curve.inBack(counter, start, stop);
  float linear= map(counter, 0, totalLength, start, stop);
  
  background(0);
  fill(#ff0000);
  rect(width*0.25, nonLinear, width/2, 100);
  fill(0);
  text("Ease-inBounce", width*0.25, nonLinear);

  fill(#ff00ff);
  rect(width*0.75, linear, width/2, 100);
  fill(0);
  text("linear", width*0.75, linear);
}
