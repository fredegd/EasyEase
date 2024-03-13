# **`.setFrameRate()`**

<br>

## Description

Sets the the [**`frameRate_`**](../globalParameters.md#framerate_) for an EasyEase object using the provided value. The `frameRate_`  determines the speed at which the motion progresses. The function accepts either an an **int** or a **float** value, which should be a positive number greater than 1.

Is recomended to set the sketch `frameRate` accordingly, using the `frameRate()` function

<br>

---

## Example:

```java hl_lines="24-27"  title="setFrameRate.pde"

--8<-- "./tools/setFrameRate/setFrameRate.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >setFrameRate.pde *</p>
  </div>

<img src="../images/tools/setFrameRate.gif" alt="setFrameRate" width="600" height="400">

</div>

 `*` the gif above runs @20fps and is only for demonstration purpose


<br>

---

## Syntax

```java
myCurve.setFrameRate(frameRate)

```
<br>

---

## Parameters

**`frameRate`** (float)  the amount of frames per second a motion cycle should be divided to

<br>

---

## Return

**void**

<br>

---

## Related


- [`.framer()`](../tools/framer.md)

- [`.setTotalLength()`](../tools/setTotalLength.md)

- [`frameRate_`](../globalParameters.md#framerate_)

<br>
