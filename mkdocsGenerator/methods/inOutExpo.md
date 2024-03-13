 <div class="table">
    <table>
        <thead>
            <tr>
                <th colspan="1">ease - in - out</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td colspan="3"><h3>Exponential</h3></td>
            </tr>
            <tr>
                <td>
                    <div class="gifImg">
                        <img src="../images/curve/Ease_inOut.gif" alt="Demo" />
                    </div>
                    <div class="fixImg">
                        <img src="../images/curve/Ease_inOut.png" alt="Demo" />
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
 </div>

# `.inOut()`

## Description

This function calculates an ease-in-out curve interpolation, returning a smooth transition that starts slowly, reaches max speed in the middle, and slows down towards the end.

The curve-bending factor is determined by the [**`intensity`**](../globalParameters.md#intensity) parameter  
it applies: the higher the value, the sharper the curve.

The returned value is by default a nonlinear interpolation between **0.0** and **1.0** or  
in case **start** and **stop** parameter are being passed as aguments, the output will be an interpolation between those two given values.

The **`counter`** parameter should be tuned according to the **`totalLength`**
e.g. if the total **`totalLength`** value was set to `3.0` seconds, the **`counter`** parameter should be an incremental value between `0.0` and `3.0` in order to complete one motion cycle.

There are three kind of cycling behaviour: either **`"loop"`** **`"alternate"`** or **`"once"`**, and when combined with an incremental **`counter`** parameter, the output will variate.

- `"loop"` the motion will loop from `0` to `1` (this is is the default option);  
  _note: the function expects the **`counter`** to be between `0.0` and **`totalLength`**_

- `"alternate"` the motion goes from `0` to `1`, then inverts from `1` back to `0`, alternatively.  
  _note: the function expects the **`counter`** to be between `0.0` and **twice** the **`totalLength`**_

- `"once"` the motion cycle from from `0` to `1` **only once**

<br>

---

## Example:

```java hl_lines="18"  title="Ease_inOut.pde"

--8<-- "./Methods/Ease_inOut/Ease_inOut.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >Ease_inOut.pde</p>
  </div>

<img src="../images/methods/ease_inOut_method.gif" alt="ease_inOut_method" width="600" height="400">

</div>
<br>

---

## Syntax

`.inOut(counter)`

`.inOut(counter,option)`

`.inOut(counter, start, stop)`

`.inOut(counter, start, stop, option)`

---

## Parameters

**`counter`** (float) an incremental value between `0` and [`totalLength`](../globalParameters.md#totallength)

**`start`** (float) the lowest desired output value

**`stop`** (float) the highest desired output value

**`option`** (String) either **`"loop"`**, **`"alternate"`** or **`"once"`**

---

## Return

**float**

<br>

---

## Related

- [.framer()](../tools/framer.md)

- [global parameters](../globalParameters.md)

<br>

---
