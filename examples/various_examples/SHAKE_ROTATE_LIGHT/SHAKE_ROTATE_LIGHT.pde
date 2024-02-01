import easy.ease.*;
String[] words = {"SHAKE", "ROTATE", "SHAKE", "ROTATE", "SHAKE", "ROTATE", "SHAKE", "ROTATE"};
float ts = 900/words.length;
EasyEase colorChange;
EasyEase[] txtAni = new EasyEase[words.length];


void setup() {
  size(900, 900, P3D);
  rectMode(CENTER);
  textSize(120);
  textAlign(CENTER, CENTER);
  colorChange = new EasyEase(this, 5, 2, 1, 0.5 );
  for (int i =0; i<words.length; i++) {
    txtAni[i]=new EasyEase(this, 3.3, 2, 1, 0.5);
  }
}

void draw() {
  // a variable for the color
  float  col = colorChange.inOutElastic(0, 255, "alternate");
  background(col);
  translate(width * 0.15, height * 0.15);
  scale(0.7);
  for (int j =0; j<txtAni.length; j++) {

    for (int i =0; i<words[j].length(); i++) {
      float wordwidth = textWidth(words[j]);
      float x = map(i, 0, words[j].length(), 0, wordwidth);
      float y = map(j, 0, words.length, 0, height)+ts/2;

      float counter = txtAni[j].framer(frameCount+j*(60/words.length)-i);
      //a variable for the shake
      float mover =      txtAni[j].inOutElastic(counter, 0, width-wordwidth, "alternate");
      //a variable for the rotation
      float rotor =      txtAni[j].inOut(counter * (60/words.length)/words[j].length(), 0, TAU, "");

      push();
      if (words[j]!="ROTATE") {
        translate(x+mover, y);
      } else {
        translate(x+wordwidth/2+ts/2, y);
        rotate(rotor);
      }
      textSize(ts);
      fill(255, 0, 0);
      text(words[j].charAt(i), 0, -ts*0.15);
      pop();
    }
  }
  fill(0);
  text("LIGHT ON", width/2, -80);
  fill(255);
  text("LIGHT OFF", width/2, height+80);
}
