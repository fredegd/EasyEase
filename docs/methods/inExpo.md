# .in()


### Description 
Calculates an ease-in curve interpolation which starts slowly and progressively speeds up,


This method expects values in a range between **0.0** and **1.0**  for the **counter** parameter and returns a nonlinear interpolation between **0.0** and **1.0**
 
in case a custom value was set for [totalLenght](./totalLength.md), the **counter** value should be tuned accordingly.
 
### Examples

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
  float mot_cont = curve.framer(frameCount);
  
  float x = curve.in(mot_cont) * (width-100);

  rect(x, 0, 100, width);
}

```



<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >Ease_in.pde</p>
  </div>

![.in()](../images/Ease_in.gif)

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
