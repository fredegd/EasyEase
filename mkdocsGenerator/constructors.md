# Constructor Functions

The EasyEase Class can be initialized in different ways, enhancing flexibility and customization

There are 3 different constructor functions each of them initializes an instances of the Class according to the provided arguments

---

## Constructor #1 - default constructor

Constructs an instance of the EasyEase Class expecting only `this`, a reference to the current Sketch, as a argument.

It assigns default values for the global [parameters](./globalParameters.md) like `intesity`, `totalLength`, `curveSpan`, and `delay`.

### Example:

```java hl_lines="5"  title="constructor_01.pde"

--8<-- "./constructor_01/constructor_01.pde:23"

```

<br>

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >constructor_01.pde</p>
  </div>
<img src="./images/default_Constructor.jpg" alt="constructor_01" width="600" height="400">

</div>

### Syntax

```java
EasyEase curve = new EasyEase( this );

```

### Parameters

**`this`** (PApplet) the current sketch

### Returns

Object

<br>
<br>
<br>
<br>
---

## Constructor #2 - with exponential intensity

Constructs an instance of the EasyEase Class expecting

- `this` as a reference to the current sketch, and
- a `float` value for the `intensity`

as arguments.

It assigns default values for other global [parameters](./globalParameters.md) `intesity`, `totalLength`, `curveSpan`, and `delay`.

### Example:

```java hl_lines="7"  title="constructor_02.pde"

--8<-- "./constructor_02/constructor_02.pde:23"

```

<br>

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >constructor_02.pde</p>
  </div>

<img src="./images/2nd_Constructor.jpg" alt="constructor_02" width="600" height="400">

</div>

### Syntax

```java

EasyEase curve = new EasyEase(this, intensity );


```

### Parameters

**`this`** (PApplet) the current sketch

**`intensity`** (float) The intensity / exponential value of the easing curve.

### Returns

Object

<br>
<br>
<br>
<br>
---

## Constructor #3 - with exponential intensity and time related parameters

Constructs an instance of the EasyEase Class expecting

- `this` as a reference to the current sketch,
- a `float` value for the `intensity` ,
- a `float` value for the `totalLength` ,
- a `float` value for the `curveSpan` ,
- a `float` value for the `delay`

as arguments.

### Example:

```java hl_lines="13"  title="constructor_03.pde"

--8<-- "./constructor_03/constructor_03.pde:23"

```

<br>

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
        <p >constructor_03.pde</p>
  </div>

<img src="./images/3rd_Constructor.jpg" alt="constructor_03" width="600" height="400">

</div>

### Syntax

```java

EasyEase curve = new EasyEase(this, intensity, totalLength, curveSpan, delay);


```

### Parameters

**`this`** (PApplet) the current sketch

**`intensity`** (float) The intensity / exponential value of the easing curve.

**`totalLength`** (float) The total length (in seconds) of the interpolation / motion

**`curveSpan`** (float) The span (in seconds) of the easing curve.

**`delay`** (float) the delay (in seconds) before the curve starts bending

### Returns

Object

<br>
<br>
