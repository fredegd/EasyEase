import easy.ease.*;

EasyEase curve = new EasyEase(this, 5);
void setup() {
  size(600, 400);
  textSize(30);
}

void draw() {
  background(#f1f1f1);
  stroke(#ff0000);
  fill(#ff0000);
  strokeWeight(5);

  float totLength = map(width-mouseX, 0, width, 0, 4);

  curve.setTotalLength(totLength);

  float ptCurve_X = curve.linear(frameCount/60.0, 50, width-50) ;
  float ptCurve_Y = height - curve.inOut(frameCount/60.0, 50, height-50) ;
  ellipse(ptCurve_X, ptCurve_Y, 50, 50 );

  text ("totalLength: "+String.format("%.2f", totLength)+" sec.", 340, 350);

  line(0, 380, width, 380);
  line(width-mouseX, 380-10, width-mouseX, 380+10);
}
