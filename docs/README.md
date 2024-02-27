# EasyEase library for Processing
Easing Function and non linear distribution utilities

![Demo](./images/promoBanner.gif)

## What is this useful for?

EasyEase provides a ready-to-use setup for an effortless application of [easing curves](#easing-curves) to a spatial distribution or an animations, resulting in more natural and visually appealing effects.
<!-- 
## Easing curves

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
</div> -->


## Download:

[here](https://github.com/fredegd/EasyEase/releases) the latest release, including the library, documentation and examples. in **.zip** format

<br>
<br>
<br>
<br>
<br>

## Installation

### ~~Library manager (not yet available)~~
~~Open Processing,~~
~~go-to: Sketch > Import Library > Manage Libraries > EasyEase~~


### Manually install:

- [Download]("https://github.com/fredegd/EasyEase/releases") the latest release of the library.

- Unzip / extract the content of **EasyEase.zip** into your Processing sketchbook's /libraries folder.

*note: sketchbook's /libraries folder is usually located under /User/Yourname/Documents/Processing/libraries.
in order to view or change your sketchbook location go to:
File > Preferences. 
The "sketchbook location" setting is the first option of the dialog*



<br>
<br>
<br>
<br>
<br>

## Docs

Documentation can be found at this [link](https://fredegd.github.io/EasyEase).


<br>
<br>
<br>
<br>
<br>

# Basic Usage

### 1) Import the Library

Once correctly installed, import the library by selecting: Sketch > Import Library > EasyEase.
or alternatively just type `import easy.ease.*` at the beginning of your sketch.

### 2) Declare and construct objects from the Class EasyEase

An EasyEase object should be declared globally. It may be constructed inside or outside the sketch's `setup()` function

_more information about all different types of constructors: [here](./constructors.md)_

### 3) Access the easing methods

Each EasyEase object contains a set of different easing [methods](./methods.md) as well as several build-in helper functions

### Example:

```java
import easy.ease.*;
float intensity = 9.2;
EasyEase  mover = new EasyEase(this, intensity);

void setup() {
  size(600, 400);
}
void draw() {
  float start = 100;
  float stop = 400;
  float motor = mover.framer(frameCount*0.5);
  
  float x = mover.inOut(motor, start, stop);
  
  fill(255, 0, 0);
  rect(x, (motor%1)*(height-100), 100,100);
}
```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >basicUsage.pde</p>
  </div>

![Basic Usage](images/basic_usage_00.gif)

</div>



<br>
<br>
<br>
<br>
<br>

### TestedPlatforms:

- OS-X
- ~~Windows~~
- ~~Linux~~


<br>
<br>
<br>
<br>
<br>
#### Processing:

**4.1.1** (The latest Processing version the library has been tested with)


<br>
<br>
<br>
<br>
<br>

### Dependencies:

EasyEase depends on no other libraries


<br>
<br>
<br>
<br>
<br>

## Other Examples:

- 1
- 2
- 3
- 4


<br>
<br>
<br>
<br>
<br>

### Source: https://github.com/fredegd/EasyEase


<br>
<br>
<br>
<br>
<br>

### This Library was written is in accordance with the [Processing library guidelines](https://github.com/benfry/processing4/wiki/Library-Guidelines)


<br>
<br>
<br>
<br>
<br>

### Keywords:

easing ,  motion,  easing-curve,  gradient,  non-linear,  curve, interpolation


<br>
<br>
<br>
<br>
<br>

### Last update

February 2024


<br>
<br>
<br>
<br>
<br>


### Issues

Issues, unexpected bugs and behaviors, or any kind of suggestion or improvement is highly welcome and can be posted --->[here](https://github.com/fredegd/EasyEase/issues)<---


<br>
<br>
<br>
<br>
<br>

### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for further information, please contact the author: [Fred Egidi](https://fredegd.dev).
