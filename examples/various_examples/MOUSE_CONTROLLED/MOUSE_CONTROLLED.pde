/**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: GRID
 * 
 * This sketch demonstrate how to control an object´s
 * motion with the mouse
 *
 * each time the mouse is being clicked, the mouseX mouseY pos
 * are set as the motion target
 * 
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */
 
 import easy.ease.*;
EasyEase xMove;
EasyEase yMove;

int base ;
int elements;
float ts;

float totalLength  =2;
float animationSpan = 1;
float delayVal = 0.5;
float expVal = 14;
color col;

float startX, startY, targetX, targetY;

Boolean newTarget = false;
void setup() {
  size(900, 900);
  rectMode(CENTER);
  xMove = new EasyEase(this);
  yMove = new EasyEase(this);
  startX=random(width);
  startY=random(height);
  targetX=mouseX;
  targetY=mouseY;
}

void draw() {

  background(0);
  fill(255);
  noStroke();
  float x = xMove.outElastic(startX, targetX, "once");
  float y = yMove.outElastic(startY, targetY, "once");
  ellipse(x, y, 200, 200);

  pointer();
}

void pointer() {
    if (newTarget) {
    col = color(255, 255, 255, 100);
  } else {
    col = color(255, 255, 255, 0);
  }
  strokeWeight(5);
  fill(col);
  noStroke();
  ellipse(mouseX, mouseY, 100, 100);
  stroke(#ff0000);
  line(mouseX-40, mouseY, mouseX+40, mouseY);
  line(mouseX, mouseY-40, mouseX, mouseY+40);
}

void mouseReleased() {

  fill(255);
  xMove.resetCounter();
  yMove.resetCounter();

  float tempX =mouseX;
  startX=  targetX;
  targetX =tempX;
  float tempY = mouseY;
  startY=targetY;
  targetY=tempY;

  newTarget = false;
}

void mousePressed() {
  newTarget = true;
}
