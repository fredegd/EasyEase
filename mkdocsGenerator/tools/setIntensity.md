# **`.setIntensity()`**

<br>

## Description

This function is used to set a value for the **`intensity`** parameter of an EasyEase Object.
!!! info

      the `intensity` parameter affects the result of the curve bending only for: [Exponential](../methods.md#exponential-easing), [Back](../methods.md#back-easing) and [Circular](../methods.md#circular-easing) easing methods

<br>

---

## Example:

```java hl_lines="22"  title="setIntensity.pde"

--8<-- "./tools/setIntensity/setIntensity.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >setIntensity.pde</p>
  </div>

<img src="../images/tools/setIntensity.gif" alt="setIntensity" width="600" height="400">

</div>

<br>

---

## Syntax

```java
myCurve.setIntensity(intensity)

```
<br>

---

## Parameters

**`intensity`**(float) the exponetial factor of the curve

<br>

---

## Return

**void**

<br>

---

## Related

- [2nd Constructor](../constructors.md#constructor-2---with-exponential-intensity)

- [3rd Constructor](../constructors.md#constructor-3---with-exponential-intensity-and-time-related-parameters)

- [`.getIntensity()`](../tools/getIntensity.md)

<br>

---
