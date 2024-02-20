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

```Processing
import easy.ease.*;

EasyEase curve = new EasyEase(this, 4);

void setup() {
  size(900,900);
  for (float i =0; i<=1; i+=0.005) {
    float interp = curve.out(i)*width;
    line(interp, i*width, interp, width);
  }
}
```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >basicUsage.pde</p>
  </div>

![Basic Usage](./sketches/basicUsage/basicUsage.jpg)

</div>
