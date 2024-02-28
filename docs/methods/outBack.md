# .outBack()

#### <-- [Easing methods](./methods.md)

### Description

Calculates an ease-in curve interpolation which starts fast and progressively slow down,

In case a custom value was set for **totalLength**, the **counter** parameter should be tuned accordingly.

It returns by default a nonlinear interpolation between **0.0** and **1.0** or in case **start** and **stop** parameter are being passed to the function, it returns an interpolation between those two values

### Example

```java
import easy.ease.*;

float intensity = 4.0;
float totalLength = 2;
float span = 1.5;
float delay = 0.25;
EasyEase curve = new EasyEase(this, intensity, totalLength, span, delay);

void setup() {
  size(600, 400);
}

void draw() {
  background(#f1f1f1);
  fill(#ff0000);
  float mot_counter = curve.framer(frameCount);

  float x = curve.outBack(mot_counter ) * (width-100);

  rect(x, 0, 100, width);
}

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >Ease_out_back.pde</p>
  </div>

![.outBack()](../images/methods/ease_outBack_method.gif)

</div>

### Syntax

`.out(counter) `

`.out(counter,option)`

`.out(counter, start, stop)`

`.out(counter, start, stop, option)`

`.out(start, stop)`

`.out(start, stop, option)`

### Parameters

**`counter`** (float) an incremental value between 0 and [totalLength](./totalLength.md)

**`start`** (float) the lowest desired output value

**`stop`** (float) the highest desired output value

**`option`** (String) either **`"loop"`** , **`"alternate"`** or **`"once"`**

### Return

**float**
