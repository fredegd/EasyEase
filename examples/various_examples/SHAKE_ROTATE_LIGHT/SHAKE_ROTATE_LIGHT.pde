/**
 * EasyEase
 * A collection of easing function for Processing.
 * https://fredegd.github.io/EasyEase/
 *
 * Example: SHAKE ROTATE LIGHT
 *
 * This sketch shows how to combine
 * differerent functions from the same
 * EasyEase instance, in order to apply
 * different effects
 *
 *
 * @author      Fred Egidi  https://github.com/fredegd
 *
 */
import easy.ease.*;
String[] words = {"SHAKE", "ROTATE", "SHAKE", "ROTATE", "SHAKE", "ROTATE", "SHAKE", "ROTATE"};
float ts = 900/words.length;
EasyEase colorChange;

EasyEase[] animation = new EasyEase[words.length];


void setup() {
  size(900, 900, P3D);
  rectMode(CENTER);
  textSize(120);
  textAlign(CENTER, CENTER);
  colorChange = new EasyEase(this, 5, 2, 1, 0.5 );
  for (int i =0; i<words.length; i++) {
    animation[i]=new EasyEase(this, 3.3, 2, 1, 0.5);
  }
}

void draw() {
  // a variable for the color
  float  col = colorChange.inOutElastic(0, 255, "alternate");
  background(col);
  translate(width * 0.15, height * 0.15);
  scale(0.7);
  fill(0);
  text("LIGHT ON", width/2, -80);
  fill(255);
  text("LIGHT OFF", width/2, height+80);
  for (int j =0; j<animation.length; j++) {

    for (int i =0; i<words[j].length(); i++) {
      float wordwidth = max(textWidth(words[j]), ts);
      float x = map(i, 0, words[j].length(), 0, wordwidth);
      float y = map(j, 0, words.length, 0, height)+ts/2;

      float counter = animation[j].framer(frameCount+j*(60/words.length)-i);
      //a variable for the shake
      float mover =      animation[j].inOutElastic(counter, 0, width-wordwidth, "alternate");
      //a variable for the rotation
      float rotor =      animation[j].outBack(counter * (60/words.length)/words[j].length(), 0, TAU, "loop");

      push();
      if (words[j]=="SHAKE") {
        fill(255, 0, 0);
        translate(x+mover, y);
      } else {
        fill(0, 0, 255);
        translate(x+wordwidth/2+ts/2, y);
        rotate(rotor);
      }
      textSize(ts);
      text(words[j].charAt(i), 0, -ts*0.15);
      pop();
    }
  }
}
