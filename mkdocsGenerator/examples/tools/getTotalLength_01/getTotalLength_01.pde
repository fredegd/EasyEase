/**
 * EasyEase
 * A collection of easing function for Processing.
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: get totalLength_01
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

EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  float totalLength = curve.getTotalLenght();
  // prints 1.0 to the console
  println(totalLength);
}
