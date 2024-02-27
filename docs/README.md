# EasyEase library for Processing
Easing Function and non linear distribution utilities

![Demo](./images/promoBanner.gif)

### What is this useful for?

EasyEase provides a ready-to-use setup for effortlessly applying [easing curves](#easing-curves) to a spatial distribution or an animations, resulting in more natural and visually appealing effects.

### Easing curves

The library offers flexible functional methods for each of the following easing curves:

- Exponential
- Sinusoidal
- Circular
- Back
- Bounce
- Elastic


<div class="table">
<table>
  <thead>
    <tr>
      <th>curve type</th>
      <th>ease-in</th>
      <th>ease-out</th>
      <th>ease-in-out</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Exponential</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_in.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_in.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_out.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_out.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOut.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOut.png" alt="Demo"></div></td>
    </tr>
    <tr>
      <td>Back</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inBack.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outBack.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutBack.png" alt="Demo"></div></td>
    </tr>
    <tr>
      <td>Circular</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inCirc.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outCirc.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutCirc.png" alt="Demo"></div></td>
    </tr>
    <tr>
      <td>Sinusoidal</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inSine.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outSine.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutSine.png" alt="Demo"></div></td>
    </tr>
    <tr>
      <td>Elastic</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inElastic.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outElastic.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutElastic.png" alt="Demo"></div></td>
    </tr>
    <tr>
      <td>Bounce</td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inBounce.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outBounce.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutBounce.png" alt="Demo"></div></td>
    </tr>

  </tbody>
</table>
</div>


### Get Started:

Download [from here](https://github.com/fredegd/EasyEase/releases) the latest release in .zip file

### Installation:

#### manually install:

Unzip / extract the content of **EasyEase.zip** into your Processing libraries folder.

#### ~~using the library manager~~

~~Open Processing,~~
~~go-to: Sketch > Import Library > Manage Libraries > EasyEase~~

### Docs

Documentation can be found [here](https://fredegd.github.io/EasyEase).

### Basic Usage

The esiest apporoach to get started with EasyEase in Processing is:

- import the library, and 
- initialize an instance of EasyEase Class object and give it a name, for example: `mover`


```Processing
import easy.ease.*;

EasyEase mover;
```

- in setup() declare the EasyEase object initialized before

```Processing
void setup(){
size(600, 400);
mover = new EasyEase(this);
mover.setIntensity(3);
}
```

- in the draw() a practical and convenient way to access the object´s build in easing
  is to call the desired Easing method, and pass in a `counter`value (default between 0 and 1), a `start` value and an `end` value as parameters like in the example:

```Processing
void draw(){
  float start = 0;
  float stop = width * 0.9;
  float x = mover.out(start, stop);
  fill(255, 0, 0);
  rect(x, 0, width * 0.1, height);
}
```
<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >basic_usage.pde</p>
  </div>

![Demo](./images/basic_usage_00.gif)

</div>



### TestedPlatforms:

- OS-X: Yes
- Windows: ( not tested yet )
- Linux: (not tested yet)

#### Processing:

4.1.1

### Dependencies:

none

### Examples


### Source: https://github.com/fredegd/EasyEase

### Keywords. easing motion easing-curve gradient non-linear curve

Last update: Januar 2024

### Download

A link to a zip file that includes the library, documentation and examples.
--->[here](https://github.com/fredegd/EasyEase/releases/)

### Issues

unexpected bugs and behaviors or any suggestion of improvement is highly welcome and can be posted --->[here](https://github.com/fredegd/EasyEase/issues)

### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for more information, or contact the author [Fred Egidi](https://fredegd.dev).
