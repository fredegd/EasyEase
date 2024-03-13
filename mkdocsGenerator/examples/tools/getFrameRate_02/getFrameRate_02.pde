/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: get framerate
 *
 * This sketch demonstrates how to use the .getFrameRate Method
 * when called it will print to the console the current frameRate value
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
 */
import easy.ease.*;

EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  
    //when setting a different `frameRate` for the object,
  //the sketch `frameRate` should be set accordingly
  frameRate(10);
  curve.setFrameRate(10);
  
  // this will print 10 to the console
  println(curve.getFrameRate());
}
