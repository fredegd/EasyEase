# EasyEase library for Processing
Easing Function and non linear distribution utilities for  [Processing](https://processing.org/) IDE

![Demo](./images/promoBanner.gif)

## General Purpose 

**EasyEase** provides a ready-to-use setup for in order to apply [easing curves](#easing-curves) to a spatial distribution or an animations, resulting in more natural and visually appealing effects.



## Download:

[here](https://github.com/fredegd/EasyEase/releases) the latest release, including the library, documentation and examples. in **.zip** format


## Installation



### opt.1: Manually install:

- [Download]("https://github.com/fredegd/EasyEase/releases") the latest release of the library.

- Unzip / extract the content of **EasyEase.zip** into your Processing sketchbook's /libraries folder.

*note: sketchbook's /libraries folder is usually located under /User/Yourname/Documents/Processing/libraries.
in order to view or change your sketchbook location go to:
File > Preferences. 
The "sketchbook location" setting is the first option of the dialog*

###  opt.1: ~~Library manager (not yet available)~~
~~Open Processing,~~
~~go-to: Sketch > Import Library > Manage Libraries > EasyEase~~



## Documentation

Documentation can be found at this [link](https://fredegd.github.io/EasyEase).



## Basic Usage

### 1) Import the Library

Once correctly installed, import the library by selecting: Sketch > Import Library > EasyEase.  
Alternatively type `import easy.ease.*` at the beginning of your sketch.

### 2) Declare and construct objects from the Class EasyEase

An EasyEase Object should be declared globally.  
It may be constructed inside or outside the sketch's `setup()` function

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




## TestedPlatforms:

- OS-X
- ~~Windows~~
- ~~Linux~~

### Processing:

The latest Processing version the library has been tested with: **4.1.1** 



### Dependencies:

EasyEase depends on no other libraries



### Other Examples:

- 1
- 2
- 3
- 4



## Source

https://github.com/fredegd/EasyEase



#### This Library was written is in accordance with the Processing library guidelines

 [info](https://github.com/benfry/processing4/wiki/Library-Guidelines)



### Keywords:

easing ,  motion,  easing-curve,  gradient,  non-linear,  curve, interpolation



### Last update

February 2024




### Issues

Issues, unexpected bugs and behaviors, or any kind of suggestion or improvement is highly welcome and can be posted [here](https://github.com/fredegd/EasyEase/issues)



### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for further information, please contact the  [author](https://fredegd.dev).
