# Getting Started

<br>

---

## Prerequisites:

<a href="https://processing.org/download" target="_blank">Processing</a>  needs to be installed in your machine.

<br>

---

## Download:

Latest release can be downloaded from [here](https://github.com/fredegd/EasyEase/releases) in **.zip** format.  
It includes the library, documentation and examples. 

<br>

---

## Installation

### opt.1: Manually install:

- [Download]("https://github.com/fredegd/EasyEase/releases") the latest release of the library.

- Unzip / extract the content of **EasyEase.zip** into your Processing sketchbook's /libraries folder.

!!! tip

    sketchbook's /libraries folder is usually located under **/User/Yourname/Documents/Processing/libraries**.
    in order to view or change your sketchbook location go to:
    **File > Preferences**.
    The **"sketchbook location"** setting is the first option of the dialog

<br>

---

### opt.2: <del>Library manager</del>

<del> Open Processing, go-to: Sketch > Import Library > Manage Libraries > EasyEase </del>

!!! info

    see also the Processing guidelines on [How-to-Install-a-Contributed-Library](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library)

<br>

---

## Basic Usage

#### 1) Import the Library

Once correctly installed, import the library by selecting: **Sketch > Import Library > EasyEase**.  
Alternatively type `import easy.ease.*` at the beginning of your sketch.

#### 2) Declare and construct objects from the Class EasyEase

An EasyEase Object should be declared globally using one of the available [constructors](./constructors.md)  
It may be constructed inside or outside the sketch's `setup()` function

#### 3) Access the easing methods

Each EasyEase object contains a set of different easing [methods](./methods.md) as well as several build-in helper functions

<br>

---

### Example:

```java hl_lines="22"  title="basic_usage.pde"

--8<-- "./basic_usage/basic_usage.pde:23"

```

<br>

<div class="exampleWindow">
  <div class="title">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
      <p >basicUsage.pde</p>
  </div>

<img src="./images/basic_usage_00.gif" alt="basic usage" width="600" height="400">

</div>

<br>
