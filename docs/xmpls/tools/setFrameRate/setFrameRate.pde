import easy.ease.*;

EasyEase curve = new EasyEase(this, 5);
void setup() {
  size(600, 400);
  textSize(30);
  curve.setTotalLength(4);
}

void draw() {
  // dinamically modulate from 2 to 60 using mouseX
  float frt = int(map(width-mouseX, 0, width, 2, 60));

  //when setting a different `frameRate` for the object,
  //the sketch `frameRate` shoulb be set accordingly
  frameRate(frt);
  curve.setFrameRate(frt);

  //using the framer() to divide frameCount to the frameRate
  float motor = curve.framer(frameCount)%4;
  float ptCurve_X = curve.linear(motor, 50, width-50) ;
  float ptCurve_Y = height - curve.inOut(motor, 50, height-50) ;

  //drawing a circle moving along the curve
  background(#f1f1f1);
  stroke(#ff0000);
  fill(#ff0000);
  strokeWeight(5);
  ellipse(ptCurve_X, ptCurve_Y, 50, 50 );
  //indicators
  text ("frameRate: "+String.format("%.2f", frt)+" fps.", 340, 350);
  text ("time: "+String.format("%.2f", motor)+" sec.", 340, 320);

  line(0, 380, width, 380);
  line(width-mouseX, 370, width-mouseX, 390);
}
