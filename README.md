# EasyEase library for Processing

### A collection of utility Functions for Easing motions and non linear distribution


The library provides a collection of function to help calculate the most common Easing Curves 
- Exponential
- Sinusoidal
- Circular
- Back
- Bounce
- Elastic

### Get Started:

The esiest apporoach to get started with EasyEase in Processing is:

- import the library
````
import easy.ease.*
````

- initialize an instance of EasyEase Class object and give it a name, for example ```mover```
````
EasyEase mover;
````

- in the setup() declare the EasyEase object initialized before
````
setup(){
size(600, 600);
mover = new EasyEase(this);
}
  ````

- in the draw() an practical and convenient way to access the object´s build in functions is to call the desired Easing function method, and pass  in a ```counter```value (default between 0 and 1), a ```start``` value and an ```end``` value as parameters like in the example:
````
  float start = 50;
  float stop = width-50;
  float x = mover.out(counter,start, stop);
  
  ellipse(x,height/2,100,100);
````

### Easing Methods

here is an example of all the easing methods and all their different variants


- EXPONENTIAL


- SINUSOIDAL
- CIRCULAR
- BACK
- BOUNCE
- ELASTIC

### TestedPlatforms:
- OS-X: Yes
- Windows: ( not tested)
- Linux: (not tested)

#### Processing:
4.1.1

### Dependencies:
none

### Examples
Thislist of examples demonstrates the use and potential of the library.
The user is warmly welcome to experiment and explore


Automated
Automated/single/automated_start_stop
Automated/single/automated_start_stop_alternate
Automated/single/automated_start_stop_loop
Automated/single/automated_start_stop_once
Comparison_distribution
Comparison_distribution/BACK/Ease_inBack
Comparison_distribution/BACK/Ease_inOutBack
Comparison_distribution/BACK/Ease_outBack
Comparison_distribution/BOUNCE/Ease_inBounce
Comparison_distribution/BOUNCE/Ease_inOutBounce
Comparison_distribution/BOUNCE/Ease_outBounce
Comparison_distribution/CIRC/Ease_inCirc
Comparison_distribution/CIRC/Ease_inOutCirc
Comparison_distribution/CIRC/Ease_outCirc
Comparison_distribution/ELASTIC/Ease_inElastic
Comparison_distribution/ELASTIC/Ease_inOutElastic
Comparison_distribution/ELASTIC/Ease_outElastic
Comparison_distribution/EXPO/Ease_in
Comparison_distribution/EXPO/Ease_inOut
Comparison_distribution/EXPO/Ease_out
Comparison_distribution/SINE/Ease_inOutSine
Comparison_distribution/SINE/Ease_inSine
Comparison_distribution/SINE/Ease_outSine


Comparison_motion
Comparison_motion/BACK/Ease_inBack
Comparison_motion/BACK/Ease_inOutBack
Comparison_motion/BACK/Ease_outBack
Comparison_motion/BOUNCE/Ease_inBounce
Comparison_motion/BOUNCE/Ease_inOutBounce
Comparison_motion/BOUNCE/Ease_outBounce
Comparison_motion/CIRC/Ease_inCirc
Comparison_motion/CIRC/Ease_inOutCirc
Comparison_motion/CIRC/Ease_outCirc
Comparison_motion/ELASTIC/Ease_inElastic
Comparison_motion/ELASTIC/Ease_inOutElastic
Comparison_motion/ELASTIC/Ease_outElastic
Comparison_motion/EXPO/Ease_in
Comparison_motion/EXPO/Ease_inOut
Comparison_motion/EXPO/Ease_out
Comparison_motion/SINE/Ease_inOutSine
Comparison_motion/SINE/Ease_inSine
Comparison_motion/SINE/Ease_outSine


Controlled
Controlled/default_0_totalLength/controlled_alternate
Controlled/default_0_totalLength/controlled_loop
Controlled/default_0_totalLength/controlled_once
Controlled/with_start_and_stop/controlled_start_stop
Controlled/with_start_and_stop/controlled_start_stop_alternate
Controlled/with_start_and_stop/controlled_start_stop_loop
Controlled/with_start_and_stop/controlled_start_stop_once


Motion_Curves
Motion_Curves/BACK/Ease_inBack
Motion_Curves/BACK/Ease_inOutBack
Motion_Curves/BACK/Ease_outBack
Motion_Curves/BOUNCE/Ease_inBounce
Motion_Curves/BOUNCE/Ease_inOutBounce
Motion_Curves/BOUNCE/Ease_outBounce
Motion_Curves/CIRC/Ease_inCirc
Motion_Curves/CIRC/Ease_inOutCirc
Motion_Curves/CIRC/Ease_outCirc
Motion_Curves/ELASTIC/Ease_inElastic
Motion_Curves/ELASTIC/Ease_inOutElastic
Motion_Curves/ELASTIC/Ease_outElastic
Motion_Curves/EXPO/Ease_in
Motion_Curves/EXPO/Ease_inOut
Motion_Curves/EXPO/Ease_out
Motion_Curves/SINE/Ease_inOutSine
Motion_Curves/SINE/Ease_inSine
Motion_Curves/SINE/Ease_outSine

various_examples


### Source: https://github.com/fredegd/EasyEase-Processing-Library

### Keywords. easing motion easing-curve gradient non-linear curve
Last update: Januar 2024



### Download
A link to a zip file that includes the library, documentation and examples.
--->[here]("https://fredegd.github.io/EasyEase-WP/")

### Disclamer

at the moment this library is still in Beta version.
it might still came out to bugs and unexpected behaviors
Any suggestion of improvement  is highly welcome and can be posted --->[here]("https://github.com/fredegd/EasyEase-Processing-Library/issues")

### Troubleshooting


If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for more information, or contact the author [Fred Egidi](https://github.com/fredegd).

