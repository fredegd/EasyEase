import easy.ease.*;

EasyEase moverX, moverY, mover3;


float ts = 50;

int startAni = 0;
int stopAni = 300;
int startAniY = 0;
int stopAniY = 300;
float expVal = 0.8;
float totalLength  = 0.5;
float animationSpan = 0.3;
float delayVal = 0.1;



void setup() {
  size(600, 600);
  moverX = new EasyEase(this,expVal, totalLength,animationSpan,delayVal);


  moverY = new EasyEase(this,expVal*2, totalLength,animationSpan,delayVal);
  //moverY.setTotalLength(totalLength);
  //moverY.setSpan(animationSpan);
  //moverY.setDelay(delayVal);

}

void draw() {
   background(1);

for(int i = 0; i<2;i++){
  float x1 =moverX.inOut( startAni, stopAni)+map(i,0,2,0,width);
  float y1 =moverY.inOut( startAniY, stopAniY);
  //float x1 =mover1.inOut(exVal, 0, width,"alternate");
  //float x2 =mover2.inOut(1, 0, width);
  //float x3 =mover3.inOut(1, 0, width);

  float y = height/2;
  fill(255);
  ellipse(x1, y1, ts, ts);
  fill(255,150);
  ellipse(map(i,0,2,0,width)+width/4, height/4, height/2, height/2);
 
  
 if (moverX.generator.getCount() >= (60*totalLength)) {

    float temp = stopAni;
    startAni = int(temp);

    temp = random(height/2);
    stopAni = int(temp);
    float tempY = stopAniY;
    startAniY = int(tempY);

    tempY = random(height/2);
    stopAniY = int(tempY);
    moverX.setSpan(random(0.2,0.4));
    moverY.setSpan(random(0.2,0.4));
  }
}




  

  //if (moverY.generator.getCount() >= (60*totalLength)) {
   
  //  float tempY = stopAniY;
  //  startAniY = int(tempY);
  //  tempY = random(height);
  //  stopAniY = int(tempY);
  //}
  
  //if (frameCount%(60*totalLength)==0){
  //  noLoop();
  //}
}
