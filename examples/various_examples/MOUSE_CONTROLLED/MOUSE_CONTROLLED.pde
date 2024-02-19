/**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase
 *
 * Example: GRID
 * 
 * This sketch demonstrate how to control an object´s
 * motion with the mouse
 *
 * each time the mouse is released, the mouseX mouseY pos
 * are set as the motion target
 * 
 * 
 * @author      Fred Egidi  https://github.com/fredegd
 */
 
 import easy.ease.*;
EasyEase xMove;
EasyEase yMove;

float startX, startY, targetX, targetY;
color ptCol;
Boolean pointerTarget = false;
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
    if (pointerTarget) {
    ptCol = color(255, 255, 255, 100);
  } else {
    ptCol = color(255, 255, 255, 0);
  }
  strokeWeight(3);
  fill(ptCol);
  noStroke();
  ellipse(mouseX, mouseY, 100, 100);
  stroke(#ff0000);
  line(mouseX-30, mouseY, mouseX+30, mouseY);
  line(mouseX, mouseY-30, mouseX, mouseY+30);
}

void mouseReleased() {
  xMove.resetCounter();
  yMove.resetCounter();

  float tempX =mouseX;
  startX=  targetX;
  targetX =tempX;
  
  float tempY = mouseY;
  startY=targetY;
  targetY=tempY;

  pointerTarget = false;
}

void mousePressed() {
  pointerTarget = true;
}
