import easy.ease.*;
float col;
EasyEase colorChange;

void setup() {
  size(900, 900, P3D);
  rectMode(CENTER);
  textAlign(CENTER, CENTER);
  textSize(100);
  colorChange = new EasyEase(this,1, 4,2,1);
}

void draw() {
  col = colorChange.inOutBounce(0, 255,"loop");
  background(col);
  translate(width * 0.15, height * 0.15);
  scale(0.7);
  fill(255-col);
  noStroke();
  rect(width/2,height/2,width,height);
  fill(col);

  text("BUZZ LIGHT", width/2, height/2+col/25);
}
