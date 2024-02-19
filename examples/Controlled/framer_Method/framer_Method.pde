/**
 * EasyEase
 * A collection of easing function for Processing
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: framer Method
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

EasyEase controlled;

float intensity = 3.0;
float start = 50;
float stop = width-50;

float totalLength = 4;
float span = 4;
float delay = 0;


void setup() {
  size(600, 600);
  rectMode(CENTER);
  controlled = new EasyEase(this, intensity, totalLength, span, delay);
  // the method getFramerate() returns the value of the
  // EasyEase object own framerate
  // default is 60.0
  //
  // when setting a different sketch frameRate, is it important
  // to call the  method setFrameRate(float value) as well
  //
  println(controlled.getFrameRate());
}

void draw() {
  background(0);
  fill(255, 0, 255);
  noStroke();
  textSize(30);
  textAlign(LEFT);
  //float count = frameCount/60.0;
  //  float count = controlled.framer(frameCount);
  float count = controlled.framer(frameCount);
  int seconds = floor(count);

  text(seconds+" seconds since the Sketch begin", 50, height-50);

  float start = 50;
  float stop = width-50;

  float x = controlled.inOut(count, start, stop, "alternate" );

  rect(x, height/2, 100, 100);
}
