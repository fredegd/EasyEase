# Usage

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
