 /**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: Motion_curves  - Ease_inCirc
 *
 * Display a motion following the selected curve function.
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */

import easy.ease.*;
EasyEase curve;
float iStep = 1.0/60.0;
float intensity =2;
float totalLength = 1;
void setup() {

  size(600, 600);
  rectMode(CENTER);
  curve = new EasyEase(this, intensity);
  //set the total lenght of the motion, (in seconds)
  curve.setTotalLength(totalLength);
}
void draw() {
  float start = 50;
  float stop = width-50;
  
  float linearCounter = curve.framer(frameCount)%totalLength;
  float pointerX= map(linearCounter, 0, totalLength, start, stop);
  float pointerY= curve.inCirc(start, stop);

  background(0);
  fill(#ff0000);
  ellipse(pointerX, pointerY, 50, 50);
  noFill();
  stroke(255);
  strokeWeight(5);
  beginShape();
  for (float i = 0; i<totalLength; i+= iStep) {
    float x= map(i, 0, totalLength, start, stop);
    float y = curve.inCirc(i, start, stop);
    vertex(x, y);
  }
  endShape();
}
