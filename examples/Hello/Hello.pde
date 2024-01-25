import easy.ease.*;

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
float expVal = 5;


void setup() {
  size(600, 600);

  for (int i =0; i<elements; i++) {
    easyease[i]=new EasyEase(this);
    easyease[i].setIntensity(expVal);
    easyease[i].setTotalLength(totalLength);
    easyease[i].setSpan(animationSpan);
    easyease[i].setDelay(map(i, 0, elements, 0, delayVal));
  }
  displayCurve = new EasyEase(this, expVal, totalLength, animationSpan, 0);
}

void draw() {
  background(1);
  translate(width * 0.1, height * 0.1);
  scale(0.8);

  for (int i =0; i<elements; i++) {
    float x =easyease[i].inOut(0, width, "loop");
    float y = map(i, 0, elements, 0, height);
    ellipse(x, y, ts, ts);
  }

  noFill();
  strokeWeight(10);
  //beginShape();
  //vertex(0, 0);
  for (float c = 0; c < 1; c += (1.0/30)) {
    float xc = map(c, 0, 1, 0, width);
    float yc = displayCurve.inOut((c+frameCount*0.01)%1)*width;
    // vertex(xc, yc);

    stroke(displayCurve.inOut(expVal, c)*255);
    line(xc, yc, xc, height);
  }
  //vertex(width, height);
  //endShape();
}
