import easy.ease.*;

EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  textSize(30);
}

void draw() {
  background(255);
  stroke(#ff0000);
  fill(#ff0000);
  strokeWeight(5);

  float intensity = map(width-mouseX, 0, width, -50, 50);
  curve.setIntensity(intensity);

  loadPixels();
  for (float i = 0; i < width; i++) {
    for (float j = 0; j < height; j++) {
      int index = int(i + j * width);
      color c = color(curve.inOutCirc( i / width, 0, 255) );
      pixels[index] = c;
    }
  }
  updatePixels();

  for (float i = 0; i < 1; i+=0.01) {
    float ptCurve_X = map(i, 0, 1, 50, width-50) ;
    float ptCurve_Y = height - curve.inOutCirc(i, 50, height-50) ;
    point(ptCurve_X, ptCurve_Y );
  }

  text (String.format("%.2f", intensity), 500, 350);

  line(0, 380, width, 380);
  line(width-mouseX, 380-10, width-mouseX, 380+10);
}
