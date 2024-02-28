# .inElastic()


### Description 
Calculates an ease-in curve interpolation which starts slowly and progressively speeds up,

In case a custom value was set for **totalLength**, the **counter** parameter should be tuned accordingly.

It returns by default a nonlinear interpolation between **0.0** and **1.0** or in case **start** and **stop** parameter are being passed to the function, it returns an interpolation between  those two values


### Example

```java
import easy.ease.*;

float intensity = 4.0;
float totalLength = 2;
float span = 1.5;
float delay = 0.25;
EasyEase curve = new EasyEase(this);

void setup() {
  size(600, 400);
  curve.setTotalLength(totalLength);
  curve.setSpan(span);
  curve.setDelay(delay);
}s

void draw() {
  background(#f1f1f1);
  fill(#ff0000);
  float mot_counter = curve.framer(frameCount);
  
  float x = curve.inElastic(mot_counter ) * (width-100);

  rect(x, 0, 100, width);
}

```


<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >Ease_in_elastic.pde</p>
  </div>

![.inElastic()](../images/methods/ease_inElastic_method.gif)

</div>


### Syntax

```.in(counter) ```


```.in(counter,option)```

```.in(counter, start, stop)```

```.in(counter, start, stop, option)```

```.in(start, stop)```

```.in(start, stop, option)```


### Parameters

**```counter```** (float)  an incremental value between 0 and [totalLength](./totalLength.md)

**```start```** (float) the lowest desired output value

**```stop```** (float) the highest desired output value

**```option```** (String)  either **```"loop"```** , **```"alternate"```** or **```"once"```**


### Return

**float**
