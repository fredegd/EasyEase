/**
* EasyEase
* A collection of easing function for Processing.
*
* https://fredegd.github.io/EasyEase/
*
* Example: Constructor default
*
* Constructs an instance of the EasyEase Class expecting
* this as a reference to the current sketch, and a  float value
* for the intensity as arguments.
*
* It assigns default values for other global parameters intesity, 
* totalLength, curveSpan, and delay.
*
*
*
*
* @author      Fred Egidi  -  https://github.com/fredegd
*
*
*/
import easy.ease.*;

// construct an instance of the EaseEase Class called curve
// passing "this" as a reference to the current sketch
// and a float value for the intensity
float intensity = 9.2;
EasyEase curve = new EasyEase(this, intensity);

void setup() {
  size(600, 400);
  stroke(#ff0000);
  noFill();
  strokeWeight(3);

  loadPixels();
  for (float x = 0; x < width; x++) {
    for (float y = 0; y < height; y++) {
      int index = int(x + y * width);
      color c = color(curve.inOut( (x / width))*255);
      pixels[index] = c;
    }
  }
  updatePixels();


  beginShape();
  for (float i = 0; i < width; i++) {
    vertex(i, (1-curve.inOut( (i / width)))*(height-4)+2 );
  }
  endShape();
}
