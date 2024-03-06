/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Constructor default
 *
 * Comparing the result of the easing distribution VS a linear distribution
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */
 
 import easy.ease.*;

float intensity = 4.3;
float totalLength = 1;
float curveSpan = 0.6;
float delay = 0.4;
EasyEase curve = new EasyEase(this, intensity, totalLength, curveSpan, delay);

void setup() {
  size(600, 400);
}

void draw(){
  background(255);
loadPixels();
  for (float x = 0; x < width; x++) {
    for (float y = 0; y < height; y++) {
      int index = int(x + y * width);
      color c = color(curve.inOutSine( (x / width+ frameCount/60.0)%1)*255);
      pixels[index] = c;
    }
  }
  updatePixels();

  stroke(#ff0000);
  noFill();
  strokeWeight(3);
  float motor = curve.framer(frameCount);
  beginShape();
  for (float i = 0; i < width; i++) {
    vertex(i, (1-curve.inOutSine( (i / width+ motor)%1))*(height-4)+2 );
  }

  endShape();
  //ellipse(0,height/2,width,width);
  //saveFrame("3rd_Constructor.jpg");
}
