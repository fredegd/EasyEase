/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set intensity
 *
 * This sketch demonstrates how to set the intensity parameter
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 */
 import easy.ease.*;

EasyEase curve = new EasyEase(this,1,1,1,0);

void setup() {
  size(600, 400);
  textSize(30);
}

void draw() {
  background(255);
  stroke(#ff0000);
  fill(#ff0000);
  strokeWeight(5);

  float start = 50;
  float stopX = width - 50;
  float stopY = 50;
  float refX = constrain(width-mouseX, start, stopX);
  float newIntensity = map(refX, start, stopX, -50, 50);
  
  curve.setIntensity(newIntensity);

  loadPixels();
  for (float i = 0; i < width; i++) {
    for (float j = 0; j < height; j++) {
      int index = int(i + j * width);
      color c = color( curve.inOut(i / width, 0, 255) );
      pixels[index] = c;
    }
  }
  updatePixels();

  for (float i = 0; i < 1; i+=0.01) {
  float ptCurve_X = curve.linear(i, start, stopX) ;
  float ptCurve_Y = curve.inOut(i, height-50, stopY) ;
    point(ptCurve_X, ptCurve_Y );
  }

  text ("intensity:"+String.format("%.2f", newIntensity), 390, 350);

  line(start, 380, stopX, 380);
  line(refX, 370, refX, 390);
}
