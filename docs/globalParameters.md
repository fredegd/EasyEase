# Global Parameters

the following parameters are global variables of each EasyEase object.

each of them receives default values until no other custom value are being assigned.

values can be passed
- during the Object instantiation
- while calling a method
- using the own setter function.




## Overview

**```intensity```** (float) The intensity / exponential value of the easing curve.

**```totalLength```** (float) The  total length (in seconds) of the interpolation / motion

**```curveSpan```** (float) The span (in seconds) of the easing curve.

**```delay```** (float) the delay (in seconds) before the curve starts bending

**```counter```** (float)  an incremental value between 0 and [totalLength](./totalLength.md)

**```start```** (float) the lowest desired output value

**```stop```** (float) the highest desired output value

**```option```** (String)  either **```"loop"```** , **```"alternate"```** or **```"once"```**




## Related:

[constructor functions](./constructors.md)

[Easing methods](./methods.md)