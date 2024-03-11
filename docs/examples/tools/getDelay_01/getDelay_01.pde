/**
 * EasyEase
 * A collection of easing function for Processing
 *
 * https://fredegd.github.io/EasyEase/
 *
 * Example: get delay
 *
 * This sketch demonstrates how to use the .getDelay Method
 * when called it will print to the console the current delay value
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
  println(curve.getDelay());
}

// prints 0.0 to the console
