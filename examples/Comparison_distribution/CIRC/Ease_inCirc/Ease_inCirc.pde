import easy.ease.*;
EasyEase curve;

float iStep = 1.0/60.0;
float intensity =2;

float start = 100;
float stop = 500;
void setup() {
  size(600, 600);
  curve = new EasyEase(this, intensity);
}

void draw() {
  background(0);
  strokeWeight(4);

  for (float i =0; i<=1.0; i+=iStep) {
    float linearDist = map(i, 0, 1.0, start, stop);
    float nonLinearDist = curve.inCirc(i, start, stop);
    //linear distribution
    stroke(#ff00ff);
    line(linearDist, 50, linearDist, height/2);
    // Nonlinear distribution
    stroke(#ff0000);
    line(nonLinearDist, height/2, nonLinearDist, height-50);
  }
}
