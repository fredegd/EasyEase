# Easing Methods

An EasyEase object contains a set of methods that reproduce the most common interpolation curves:

- [Exponential easing](#Exponential-easing)
- [Sinusoidal easing](#Sinusoidal-Easing)
- [Circular easing](#Circular-easing)
- [Elastic easing](#Elastic-Easing)
- [easing Bounce](#Bounce-Easing)
- [easing Back](#Back-Easing)

given an input parameter, returns a non-linear rate of change over time.



# Exponential Easing
Exponential easing accelerates or decelerates motion based on the value of the exponential factor. 
### ease-in
It starts slowly and progressively speeds up,
### ease-out
It starts fast and progressively slows down,
### ease-in-out
It starts slow, accelerates and reaches full-speed at the midpoint, then  and progressively slows down,


The rate of acceleration depends on the input parameter, allowing for customizable easing effects.

# Sinusoidal Easing
Sinusoidal easing applies a sinusoidal function to the motion, resulting in a smooth, wave-like transition. It produces a graceful and rhythmic movement, suitable for achieving a harmonious flow in animations and transitions.

# Circular Easing
Circular easing follows a circular motion pattern, providing a gentle acceleration and deceleration. This method is characterized by its rounded curves, creating a soft and pleasant change in motion.

# Elastic Easing
Elastic easing simulates an elastic or rubber band-like motion, causing the object to overshoot its target before settling into the final position. This method is useful for creating playful and bouncy animations.

# Bounce Easing
Bounce easing mimics the behavior of a bouncing ball, introducing a series of bounces as the motion progresses. This method adds a dynamic and lively quality to animations, resembling the way objects bounce in the real world.

# Back Easing
Back easing incorporates a brief overshoot before settling into the target position. This method is characterized by a slight backward motion before moving forward, creating an effect similar to pulling back and releasing a spring.

