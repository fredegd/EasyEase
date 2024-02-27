# Easing Methods  

An EasyEase object contains a set of methods that reproduce the most common interpolation curves:

- [Exponential easing](#Exponential-easing)
- [Sinusoidal easing](#Sinusoidal-Easing)
- [Circular easing](#Circular-easing)
- [Elastic easing](#Elastic-Easing)
- [easing Bounce](#Bounce-Easing)
- [easing Back](#Back-Easing)

# Exponential Easing

Exponential easing accelerates or decelerates motion based on the value of the exponential factor.
the higher the factor, the steeper the curve

### .in()
It starts slowly and progressively speeds up,

### .out()
It starts fast and progressively slows down,

### .inOut()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.in()</th>
      <th>.out()</th>
      <th>.inOut()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_in.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_in.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_out.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_out.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOut.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOut.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>

# Back Easing

Back easing incorporates a brief overshoot before settling into the target position. This method is characterized by a slight backward motion before moving forward, creating an effect similar to pulling back and releasing a spring.

### .inBack()
It starts slowly and progressively speeds up,

### .outBack()
It starts slowly and progressively speeds up,

### .inOutBack()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.inBack()</th>
      <th>.outBack()</th>
      <th>.inOutBack()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_inBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inBack.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outBack.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutBack.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutBack.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>

# Circular Easing

Circular easing follows a circular motion pattern. This method is characterized by its rounded curves

### .inCirc()
It starts slowly and progressively speeds up,

### .outCirc()
It starts slowly and progressively speeds up,

### .inOutCirc()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.inCirc()</th>
      <th>.outCirc()</th>
      <th>.inOutCirc()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_inCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inCirc.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outCirc.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutCirc.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutCirc.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>



# Sinusoidal Easing

Sinusoidal easing applies a sinusoidal function to the motion, resulting in a smooth, wave-like transition, providing a gentle acceleration and deceleration.

### .inSine()
It starts slowly and progressively speeds up,

### .outSine()
It starts slowly and progressively speeds up,

### .inOutSine()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.inSine()</th>
      <th>.outSine()</th>
      <th>.inOutSine()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_inSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inSine.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outSine.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutSine.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutSine.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>



# Elastic Easing

Elastic easing simulates an elastic or rubber band-like motion, causing the object to overshoot its target before settling into the final position. This method is useful for creating bouncy animations.
### .inElastic()
It starts slowly and progressively speeds up,

### .outElastic()
It starts slowly and progressively speeds up,

### .inOutElastic()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.inElastic()</th>
      <th>.outElastic()</th>
      <th>.inOutElastic()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_inElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inElastic.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outElastic.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutElastic.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutElastic.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>


# Bounce Easing

Bounce easing mimics the behavior of a bouncing ball, introducing a series of bounces as the motion progresses.
This method adds a dynamic animation, resembling the way objects bounce in the real world.

### .inBounce()
It starts slowly and progressively speeds up,

### .outBounce()
It starts slowly and progressively speeds up,

### .inOutBounce()
It starts slow, accelerates until reaching full-speed at the midpoint, then and progressively slows down.  



<div class="table">
<table>
  <thead>
    <tr>
      <th>.inBounce()</th>
      <th>.outBounce()</th>
      <th>.inOutBounce()</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><div class="gifImg"><img src="./images/curve/Ease_inBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inBounce.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_outBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_outBounce.png" alt="Demo"></div></td>
      <td><div class="gifImg"><img src="./images/curve/Ease_inOutBounce.gif" alt="Demo"></div><div class="fixImg"><img src="./images/curve/Ease_inOutBounce.png" alt="Demo"></div></td>
    </tr>
  </tbody>
</table>
</div>
<br>
<br>
<br>
<br>
<br>

