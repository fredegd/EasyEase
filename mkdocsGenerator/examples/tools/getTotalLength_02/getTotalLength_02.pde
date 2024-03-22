/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: set totalLength_01
 *
 * This function returns the totalLength value of an EasyEase Object.
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

EasyEase curve = new EasyEase(this, 4.0, 2.0, 2.0, 0.0);

void setup() {
  size(600, 400);
  float totalLength = curve.getTotalLength();
  // prints 2.0 to the console
  println(totalLength);
}
