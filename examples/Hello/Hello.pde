import functions.ease.*;

EasyEase displayCurve;

int elements = 10;
float ts = 600/elements;

EasyEase[] easyease = new EasyEase[elements];
float counter = 0;
int startAni = 0;
int stopAni = 600;
float totalLength  = 2;
float delayVal = 0.5;
float animationSpan = 0.5;
float exVal = 5;


void setup() {
  size(600, 600);

  for (int i =0; i<elements; i++) {
    easyease[i]=new EasyEase(this);
    easyease[i].setTotalLength(totalLength);
    easyease[i].setSpan(animationSpan);
    easyease[i].setDelay(map(i, 0, elements, 0, delayVal));
  }
  displayCurve = new EasyEase(this);
}

void draw() {
  background(1);
  translate(width * 0.1, height * 0.1);
  scale(0.8);

  for (int i =0; i<elements; i++) {
    float x =easyease[i].inOut(exVal,0,width,"loop");

    float y = map(i, 0, elements, 0, height);
    fill(255);
    ellipse(x, y, ts, ts);
  }

  noFill();

strokeWeight(10);
  //beginShape();
  //vertex(0, 0);
  for (float c = 0; c < 1; c += (1.0/30)) {
    float xc = map(c, 0, 1, 0, width);
    float yc = displayCurve.inOut(4.0,(c+frameCount*0.01)%1)*width;
   // vertex(xc, yc);
    
    stroke(displayCurve.inOut(exVal,c)*255);
    line(xc,yc,xc,height);
  }
  //vertex(width, height);
  //endShape();
}
