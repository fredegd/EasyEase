/**
 * EasyEase
 * A collection of easing function for Processing.
 * https://fredegd.github.io/EasyEase/-Processing-Library
 *
 * Example: GRID
 * 
 * This sketch demonstrate how to initialize an array of 
 * EasyEase Objects passing totalLength, animationSpan, delayMap
 * as parameters
 *
 * since each element receives a different delay value,
 * when placed in a grid, for example it produces  very
 * interesting motion effects
 * 
 * the "alternate" option ensures
 * the result motion cummutes back and forth 
 * from the  start to the stop value.
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */
 
import easy.ease.*;
EasyEase[] easyease;


int base ;
int elements;
float ts;

float totalLength  =4;
float animationSpan = 2;
float delayVal = 0.5;
float expVal = 14;
float col;

void setup() {
  size(900, 900, P3D);
  rectMode(CENTER);
  base = 10;
  elements = base*base;
  ts = width/base;
  easyease = new EasyEase[elements];
  for (int i =0; i<elements; i++) {
    float delayMap = map(i, 0, elements, 0, animationSpan/2);
    easyease[i]=new EasyEase(this, expVal, totalLength, animationSpan, delayMap);
  }
}

void draw() {
  background(10);
  noStroke();
  for (int i =0; i<elements; i++) {
    float x = i%base * ts + ts/2;
    float y = int(i/base)*ts+ts/2;

    float motor = easyease[0].framer(frameCount);
    float mot1 =easyease[i].inOut(motor, 0.0, 1.0, "alternate");
    float mot2 =ts*0.125-easyease[i].inOutBack( 2*motor, "alternate")*ts*0.25;


    float rectW = map(mot1, 0, 1, ts*0.75, ts*0.25)+mot2;
    float rectH =map(mot1, 0, 1, ts*0.25, ts*0.75)+mot2;

    col=(map(mot2, -ts*0.125, ts*0.125, 0, 255));

    push();
    translate(x, (y), mot2*4);
    rotateY(mot1*PI);
    fill(255-mot1*255, 255, 255-col);
    rect(0, 0, rectW, rectH);
    pop();
  }
}
