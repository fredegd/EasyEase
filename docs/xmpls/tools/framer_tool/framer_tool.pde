/**
 * EasyEase
 * A collection of easing function for Processing
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: framer tool
 *
 * this example shows how to use and leverage the power
 * of the framer  method.
 *
 * it receives any float values and returns
 * the input value divided by the frame rate
 * default frameRate is 60.0
 *
 * it might be useful when the frameCount or any
 * similar increasing value
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 *
 */

import easy.ease.*;

float intensity = 3.0;
float totalLength = 4;
float span = 2;
float delay = 1;
EasyEase   controlled = new EasyEase(this, intensity, totalLength, span, delay);


void setup() {
  size(600, 600);
  rectMode(CENTER);
  // the method getFramerate() returns the value of the
  // EasyEase object own framerate
  // default is 60.0 fps
  //
  // when setting a different sketch frameRate, is it important
  // to call the  method setFrameRate(float value) as well
  //
  frameRate(60);
  controlled.setFrameRate(60);

  println("object´s frame rate: "+controlled.getFrameRate());
}

void draw() {
  background(#f1f1f1);
  fill(#ff0000);
  noStroke();
  textSize(30);
  textAlign(LEFT);
  
  float count = controlled.framer(frameCount);
  int seconds = floor(count);

  text(seconds+" seconds since the Sketch begin", 50, height-50);

  float start = 50;
  float stop = width-50;

  float x = controlled.inOut(count, start, stop, "loop" );

  rect(x, height/2, 100, 100);
}
