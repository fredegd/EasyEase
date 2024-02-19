/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Motion_curves  - Ease_inOutBack
 *
 * Display a motion following the selected curve function.
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */



import easy.ease.*;
EasyEase curve;
float iStep = 1.0/60.0;
float intensity =1;
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
  float stop = height-50;

  float linearCounter = curve.framer(frameCount)%totalLength;
  float pointerX= map(linearCounter, 0, totalLength, start, stop);
  float pointerY= curve.inOutBack(start, stop);

  background(0);
  fill(0);
  rect(width/2,height/2,width-100,height-100);
  fill(#ff0000);
  ellipse(pointerX, pointerY, 50, 50);

  noFill();
  stroke(255);
  strokeWeight(5);
  beginShape();

  for (float i = 0; i<=totalLength; i+= iStep) {
    float x= map(i, 0, totalLength, start, stop);
    float y = curve.inOutBack(i, start, stop);
    vertex(x, y);
  }
  endShape();
}
