/**
 * EasyEase
 * A collection of easing function for Processing.
 * https://github.com/fredegd/EasyEase-Processing-Library
 *
 * Example: BUZZ_LIGHT
 * 
 * recreates the effect of a buzzing light using 
 * the inOutBounce easing method
 * 
 * the result motion cummutes back and forth 
 * from the  start to the stop value.
 * 
 * @author      Fred Egidi  https://fredegd.dev/
 */
 
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
  col = colorChange.inOutBounce(0, 255,"alternate");
  background(col);
  translate(width * 0.15, height * 0.15);
  scale(0.7);
  fill(255-col);
  noStroke();
  rect(width/2,height/2,width,height);
  fill(col);

  text("BUZZ LIGHT", width/2, height/2+col/25);
}
