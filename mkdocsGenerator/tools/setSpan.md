# **`.setSpan()`**

<br>

## Description

This function is used to set a value for the [**` span `**](../globalParameters.md#span)  variable of an EasyEase Object.

It receives a float value which should be positive and should be greater than `0.0` and less or equal than **`totalLength`**;


<br>

---

## Example:

```java hl_lines="24"  title="setSpan.pde"

--8<-- "./tools/setSpan/setSpan.pde:23"

```

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >setSpan.pde</p>
  </div>

<img src="../images/tools/setSpan.gif" alt="setSpan" width="600" height="400">

</div>

<br>

---

## Syntax

```java
myCurve.setSpan(span)

```
<br>

---

## Parameters

**`span`**(float)  the motion span expressed in seconds

<br>

---

## Return

**void**

<br>

---

## Related


- [3rd Constructor](../constructors.md#constructor-3---with-exponential-intensity-and-time-related-parameters)

- [`.getSpan()`](../tools/getSpan.md)

- [`.setTotalLength()`](../tools/setTotalLength.md)

- [`.setDelay()`](../tools/setDelay.md)

<br>
