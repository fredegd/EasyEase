# **`.setTotalLength()`**

<br>

## Description

This function is used to set a value for the [**`totalLength`**](../globalParameters.md#totallength) parameter of an EasyEase Object expressed in seconds.

It receives a float value which should positive and be greater than 0.0 to avoid unexpected results.

<br>

---

## Example:

```java hl_lines="23"  title="setTotalLength.pde"

--8<-- "./tools/setTotalLength/setTotalLength.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >setTotalLength.pde</p>
  </div>

<img src="../images/tools/setTotalLength.gif" alt="setTotalLength" width="600" height="400">

</div>

<br>

---

## Syntax

```java
myCurve.setTotalLength(totalLength)

```
<br>

---

## Parameters

**`totalLength`**(float) the duration in seconds of the motion

<br>

---

## Return

**void**

<br>

---

## Related


- [3rd Constructor](../constructors.md#constructor-3---with-exponential-intensity-and-time-related-parameters)

- [`.setSpan()`](../tools/setSpan.md)

- [`.setDelay()`](../tools/setDelay.md)

<br>
