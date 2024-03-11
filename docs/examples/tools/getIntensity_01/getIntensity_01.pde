/**
* EasyEase
* A collection of easing function for Processing.
*
* https://fredegd.github.io/EasyEase/
*
* Example: get intensity_01
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

EasyEase curve = new EasyEase(this, 4.0);

void setup() {
    size(600, 400);
    
    // prints 4.0 to the console
    println(curve.getIntensity());
}
