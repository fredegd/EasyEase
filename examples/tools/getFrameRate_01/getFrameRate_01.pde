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

  // this will print 60 to the console
  println(curve.getFrameRate());
}
