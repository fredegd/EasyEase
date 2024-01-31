import easy.ease.*;
EasyEase curve;
float iStep = 1.0/60.0;
float intensity =2;
float totalLength = 2;
void setup() {
  size(600, 600);
  textSize(30);
  rectMode(CENTER);
  textAlign(CENTER,CENTER);
  curve = new EasyEase(this, intensity);
  //set the total lenght of the motion, (in seconds)
  curve.setTotalLength(totalLength);
}
void draw() {
  float start = 50;
  float stop = width-50;

  float linearCounter = curve.framer(frameCount)%totalLength;
  float pointerX= map(linearCounter, 0, totalLength, start, stop);
  float pointerY= curve.inOutBack(linearCounter, start, stop);

  background(0);
  fill(#ff0000);
  rect(width*0.25, pointerY, width/2, 100);
  fill(0);
  text("Ease-inOutBack", width*0.25, pointerY);

  fill(#ff00ff);
  rect(width*0.75, pointerX, width/2, 100);
  fill(0);
  text("linear", width*0.75, pointerX);
}
