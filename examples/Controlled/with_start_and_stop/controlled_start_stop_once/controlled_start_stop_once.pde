import easy.ease.*;
EasyEase mover;
float intensity = 3.0;
void setup() {
  size(600, 600);
  rectMode(CENTER);
  mover = new EasyEase(this, intensity);
}
void draw() {
  background(0);
  fill(255, 0, 255);
  noStroke();
  float count = frameCount/60.0;
  //alternatively:
  //float count = mover.framer(frameCount);

  float start = 50;
  float stop = width-50;

  float x = mover.out(count, start, stop, "once");

  rect(x, height/2, 100, 100);
}
