/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: Comparison_distribution All Curve
 *
 * Comparing the result of all the different easing distribution
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
  float newIntensity = map(mouseX, 0, width, -2, 2);
  curve.setIntensity(newIntensity);

  background(0);
  translate(width*0.15, height*0.15);
  scale(0.7);
  float tw = width/strokes;

  for (float i =0; i<=1; i+=step) {

    float framed = curve.framer(i*60.0)*totalLength;

    //linear distribution
    float linearDist = curve.linear(framed, "once")*width;
    strokeWeight(1);
    stroke(255, 100);
    line(linearDist, 0, linearDist, height);


    //// Nonlinear distribution
    //
    //
    fill(#F3A712, 150);
    text("exponential easing", 0, -30);


    float in = curve.in(framed, "once")*width;
    ellipse(in, 0, tw, 30);

    float out = curve.out(framed, "once")*width;
    ellipse(out, 40, tw, 30);


    float inOut = curve.inOut(framed, "once")*width;
    ellipse(inOut, 80, tw, 30);
    //
    //
    fill(#d21bdc, 150);
    text("back easing", 0, 130);


    float inBack = curve.inBack(framed, "once")*width;
    ellipse(inBack, 160, tw, 30);


    float outBack = curve.outBack(framed, "once")*width;
    ellipse(outBack, 200, tw, 30);


    float inOutBack = curve.inOutBack(framed, "once")*width;
    ellipse(inOutBack, 240, tw, 30);

    //
    //
    fill(#e14f35, 150);
    text("curcular easing", 0, 290);


    float inCirc = curve.inCirc(framed, "once")*width;
    ellipse(inCirc, 320, tw, 30);


    float outCirc = curve.outCirc(framed, "once")*width;
    ellipse(outCirc, 360, tw, 30);


    float inOutCirc = curve.inOutCirc(framed, "once")*width;
    ellipse(inOutCirc, 400, tw, 30);


    //
    //
    fill(#6ece4b, 150);
    text("sinusoidal easing", 0, 450);

    float inSine = curve.inSine(framed, "once")*width;
    ellipse(inSine, 480, tw, 30);


    float outSine = curve.outSine(framed, "once")*width;
    ellipse(outSine, 520, tw, 30);


    float inOutSine = curve.inOutSine(framed, "once")*width;
    ellipse(inOutSine, 560, tw, 30);
    //
    //
    fill(#f0ff4d, 150);
    text("elastic easing", 0, 610);

    float inElastic = curve.inElastic(framed, "once")*width;
    ellipse(inElastic, 640, tw, 30);

    float outElastic = curve.outElastic(framed, "once")*width;
    ellipse(outElastic, 680, tw, 30);

    float inOutElastic = curve.inOutElastic(framed, "once")*width;
    ellipse(inOutElastic, 720, tw, 30);
    //
    //
    fill(#5c92ff, 150);
    text("bounce easing", 0, 770);

    float inBounce = curve.inBounce(framed, "once")*width;
    ellipse(inBounce, 800, tw, 30);


    float outBounce = curve.outBounce(framed, "once")*width;
    ellipse(outBounce, 840, tw, 30);


    float inOutBounce = curve.inOutBounce(framed, "once")*width;
    ellipse(inOutBounce, 880, tw, 30);
  }
}
