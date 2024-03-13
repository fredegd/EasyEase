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

EasyEase curve = new EasyEase(this, 4.0, 2.0, 1.5, 0.5);

void setup() {
    size(600, 400);
    float delay = curve.getDelay();
    // prints 0.5 to the console
    println(delay);
}
