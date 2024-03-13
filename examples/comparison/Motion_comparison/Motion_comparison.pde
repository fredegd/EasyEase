/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Comparison_motion All Curve
 *
 * Comparing the result of all the different easing motions
 *
 *
 *
 *
 *
 *
 *
 *
 * @author      Fred Egidi  -  https://github.com/fredegd
 *
 *
 *
 */
import easy.ease.*;
EasyEase curve;

float totalLength = 4.0;

float strokes = 80.0;
float step = 1/strokes;

void setup() {
  size(900, 900);
  curve = new EasyEase(this);
  curve.setIntensity(1.75);
  curve.setTotalLength(totalLength);
  curve.setLog(false);

  textSize(30);
}
void draw() {

  background(0);
  translate(width*0.15, height*0.15);
  scale(0.7);
  float tw = width/strokes;

  float framed = curve.framer(frameCount);

  //
  //linear
  //

  float linearMot = curve.linear(framed)*width;
  strokeWeight(1);
  fill(255);
  stroke(255);
  text("linear", linearMot, height+30);
  line(linearMot, 0, linearMot, height);
  //
  //
  //exponential
  //
  fill(#F3A712);
  text("exponential easing", 0, -30);
  float in = curve.in(framed)*width;
  ellipse(in, 0, tw, 30);
  float out = curve.out(framed)*width;
  ellipse(out, 40, tw, 30);
  float inOut = curve.inOut(framed)*width;
  ellipse(inOut, 80, tw, 30);
  //
  // back
  //
  fill(#d21bdc);
  text("back easing", 0, 130);
  float inBack = curve.inBack(framed)*width;
  ellipse(inBack, 160, tw, 30);
  float outBack = curve.outBack(framed)*width;
  ellipse(outBack, 200, tw, 30);
  float inOutBack = curve.inOutBack(framed)*width;
  ellipse(inOutBack, 240, tw, 30);
  //
  //circular
  //
  fill(#e14f35);
  text("curcular easing", 0, 290);
  float inCirc = curve.inCirc(framed)*width;
  ellipse(inCirc, 320, tw, 30);
  float outCirc = curve.outCirc(framed)*width;
  ellipse(outCirc, 360, tw, 30);
  float inOutCirc = curve.inOutCirc(framed)*width;
  ellipse(inOutCirc, 400, tw, 30);
  //
  //sinusoidal
  //
  fill(#6ece4b);
  text("sinusoidal easing", 0, 450);
  float inSine = curve.inSine(framed)*width;
  ellipse(inSine, 480, tw, 30);
  float outSine = curve.outSine(framed)*width;
  ellipse(outSine, 520, tw, 30);
  float inOutSine = curve.inOutSine(framed)*width;
  ellipse(inOutSine, 560, tw, 30);
  //
  //elastic
  //
  fill(#f0ff4d);
  text("elastic easing", 0, 610);
  float inElastic = curve.inElastic(framed)*width;
  ellipse(inElastic, 640, tw, 30);
  float outElastic = curve.outElastic(framed)*width;
  ellipse(outElastic, 680, tw, 30);
  float inOutElastic = curve.inOutElastic(framed)*width;
  ellipse(inOutElastic, 720, tw, 30);
  //
  //bounce
  //
  fill(#5c92ff);
  text("bounce easing", 0, 770);
  float inBounce = curve.inBounce(framed)*width;
  ellipse(inBounce, 800, tw, 30);
  float outBounce = curve.outBounce(framed)*width;
  ellipse(outBounce, 840, tw, 30);
  float inOutBounce = curve.inOutBounce(framed)*width;
  ellipse(inOutBounce, 880, tw, 30);

}
