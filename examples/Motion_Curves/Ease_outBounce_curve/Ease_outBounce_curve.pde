/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Motion_curves  - Ease_outBounce
 *
 * Display a motion following the selected curve function.
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */


import easy.ease.*;
float step = 1/120.0 ;
EasyEase curve = new EasyEase(this);
void setup() {
  size(600, 600);
}

void draw() {
  float start = 50;
  float stop = width-50;

  float counter = curve.framer(frameCount);
  float pointerX=  curve.linear(counter, start, stop);
  float pointerY= curve.outBounce(counter, start, stop);

  background(0);
  fill(#ff0000);
  ellipse(pointerX, pointerY, 50, 50);
  noFill();
  stroke(255);
  strokeWeight(5);
  beginShape();
  for (float i = 0; i<1; i+= step) {
    float x= curve.linear(i, start, stop);
    float y = curve.outBounce(i, start, stop);
    vertex(x, y);
  }
  endShape();
}