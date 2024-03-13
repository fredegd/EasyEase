# **`.setDelay()`**

<br>

## Description

This function is used to set a value for the [**`delay`**](../globalParameters.md#delay) variable of an EasyEase Object.

It receives a **float** value which should be positive and may be greater or equal than `0.0`;

<br>

---

## Example:

```java hl_lines="22-26"  title="setDelay.pde"

--8<-- "./tools/setDelay/setDelay.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >setDelay.pde</p>
  </div>

<img src="../images/tools/setDelay.gif" alt="setDelay" width="600" height="400">

</div>

<br>

---

## Syntax

```java
myCurve.setDelay(delay)

```
<br>

---

## Parameters

**`delay`**(float)  the motion span expressed in seconds

<br>

---

## Return

**void**

<br>

---

## Related


- [3rd Constructor](../constructors.md#constructor-3---with-exponential-intensity-and-time-related-parameters)

- [`.getDelay()`](../tools/getDelay.md)

- [`.setTotalLength()`](../tools/setTotalLength.md)

- [`.setSpan()`](../tools/setSpan.md)

<br>
