# **`.framer()`**

<br>

## Description

Converts the input frame count or any other incremetal value to seconds by dividing it by the current motion `frameRate_`. This function is particularly useful for converting frame-based incremental values to a more intuitive time scale since it is based on seconds.

The returned value can be used as a `counter` parameter for any of the [easing methods](../methods.md)
<br>

---

## Example


```java hl_lines="33"  title="framer_tool.pde"

--8<-- "./tools/framer_tool/framer_tool.pde:23"

```


<br>

---

## Syntax

```java
myCurve.framer(count)
```
<br>

---

## Parameters

**`count`** (float) The incremental value to be converted, e.g. the `frameCount`

<br>

---

## Return

**float**

<br>

---

## Related

- [`.setFrameRate()`](./setFrameRate.md)

<br>
