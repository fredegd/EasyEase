/**
* EasyEase
* A collection of easing function for Processing.
*
* https://fredegd.github.io/EasyEase/
*
* Example: get span_01
*
* This sketch demonstrates how to use the .getSpan Method
* when called it will print to the console the current span value
* 
* The span variable determines the length of the curve bending time,
* in other words: how many seconds should a motion last.
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
