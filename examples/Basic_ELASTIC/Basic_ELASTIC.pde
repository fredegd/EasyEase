import easy.ease.*;

EasyEase moverX, moverX1, moverX2;
void setup() {
  size(600, 600);
  moverX = new EasyEase(this, 1,2,2,0);
  moverX1 = new EasyEase(this, 1,2,2,0);
  moverX2 = new EasyEase(this, 1,2,2,0);
}

void draw() {
  background(1);

  //float ct =( frameCount*(1/60.0))%1;
  float ct = map(frameCount,0,60,0,1.0);

  float x = moverX.inElastic(0,width);
  float x1 = moverX1.inElastic(ct)*width;
  float x2 = moverX2.outElastic(ct)*width;

  ellipse(x, height/2-100, 100, 100);
  ellipse(x1, height/2, 100, 100); 
  ellipse(x2, height/2+100, 100, 100);
}
