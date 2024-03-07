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

//construct an instance of the EaseEase Class called curve
// using "this" as a reference to the current sketch

EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
   stroke(#ff0000);
  noFill();
  strokeWeight(3);
  
  loadPixels();
  for (float x = 0; x < width; x++) {
    for (float y = 0; y < height; y++) {
      int index = int(x + y * width);
      color c = color(curve.inOutSine( x / width)*255);
      pixels[index] = c;
    }
  }
  updatePixels();

  beginShape();
  for (float i = 0; i < width; i++) {
    vertex(i, (1-curve.inOutSine( (i / width)))*(height-4)+2 );
  }
  endShape();
}
