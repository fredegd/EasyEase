package easy.ease;

/**
 * EasingMethods class provides methods for easing motion computations. It
 * encapsulates parameters and methods related to easing functions.
 */
public class EasingMethods {

	private float expIntensity;
	private float totalLength;
	private float delay;
	private float span;
	private float motionFrameRate;
	private float step;
	private float count = 0;
	private boolean log;

	private float c1;
	private float c2;
	private float c3;
	private float c4;
	private float c5;

	/**
	 * Constructs an instance of the EasingMethods class with specified parameters.
	 *
	 * @param motionFrameRate The frame rate for motion.
	 * @param expIntensity    The intensity/exponent value for easing.
	 * @param totalLength     The total length of the easing motion.
	 * @param span            The span of the easing motion.
	 * @param delay           The delay before the easing motion starts.
	 */
	public EasingMethods(float expIntensity, float totalLength, float span, float delay, float motionFrameRate) {

		this.expIntensity = expIntensity;
		this.totalLength = totalLength;
		this.span = span;
		this.delay = delay;
		this.motionFrameRate = motionFrameRate;
		this.step = 1f / motionFrameRate;

		this.c1 = this.expIntensity;
		this.c2 = (float) (this.c1 * 1.5);
		this.c3 = this.c1 + 1;
		this.c4 = (float) ((2 * Math.PI) / 3);
		this.c5 = (float) ((2 * Math.PI) / 4.5);

		this.log = true;

	}

	///////////////////////////////////////////////////
	// Getters and Setters for easing-related variables
	///////////////////////////////////////////////////

	/**
	 * Sets the frame rate for motion.
	 *
	 * @param frt The frame rate to be set.
	 */
	public void setFrameRate(float frt) {
		motionFrameRate = frt;
		this.step = 1f / frt;
		if (this.log)
			System.out.println("Motion Framerate set to " + this.motionFrameRate + "fps");
	}

	/**
	 * Gets the current frame rate for motion.
	 *
	 * @return The current frame rate.
	 */
	public float getFrameRate() {
		return this.motionFrameRate;
	}

	/**
	 * Sets the intensity/exponent value for the easing motion.
	 *
	 * @param expVal The new intensity/exponent value to be set.
	 */
	public void setIntensity(float expVal) {
		this.expIntensity = expVal;
		if (this.log)
			System.out.println("Curve intensity set to " + this.expIntensity);
	}

	/**
	 * Gets the intensity/exponent value of the easing motion.
	 *
	 * @return The intensity/exponent value.
	 */
	public float getIntensity() {
		return this.expIntensity;
	}

	/**
	 * Sets the total length of the easing motion.
	 *
	 * @param length The new total length to be set.
	 */
	public void setTotalLength(float length) {
		this.totalLength = length;
		this.span = this.totalLength - this.delay;
		if (this.log)
			System.out.println("Total length set to " + this.totalLength + "sec.");
	}

	/**
	 * Gets the total length of the easing motion.
	 *
	 * @return The total length of the easing motion.
	 */
	public float getTotalLength() {
		return this.totalLength;
	}

	/**
	 * Sets the motion span of the easing motion. The motion span is the duration of
	 * the motion excluding the delay.
	 *
	 * @param length The new motion span to be set.
	 */
	public void setSpan(float length) {

		float ref = (this.totalLength - this.delay);
		if (length > ref) {
			if (this.log)
				System.out.println("### \n  # setSpan WARNING: a total Length of " + this.totalLength + " sec.\n"
						+ "  # and a delay of " + this.delay + " sec. has been set.  \n"
						+ "  # Currently, the max. allowed Motion span is " + ref + " sec.\n###");
			this.span = ref;
		} else if (length <= ref) {
			this.span = length;
		}
		if (this.log)
			System.out.println("Motion span is now set to " + this.span + "sec.");
	}

	/**
	 * Gets the motion span of the easing motion. The motion span is the duration of
	 * the motion excluding the delay.
	 *
	 * @return The motion span of the easing motion.
	 */
	public float getSpan() {
		return this.span;
	}

	/**
	 * Sets the delay of the motion. The delay is the time before the motion starts.
	 * Adjusts the motion span accordingly if needed.
	 *
	 * @param amt The new delay value to be set.
	 */
	public void setDelay(float amt) {
		float ref = this.totalLength - this.span;
		float newSpan = this.totalLength - amt;
		this.delay = amt;
		if (this.log)
			System.out.println("Delay is now set to " + this.delay + " sec.");
		if (amt > ref) {
			if (this.log)
				System.out.println("###\n  # setDelay WARNING: setting " + amt + " seconds delay, will \n"
						+ "  # shorten the max allowed Motion span to " + newSpan + " sec.\n###");
			this.span = newSpan;
		}

		if (amt > this.totalLength) {

			if (this.log)
				System.out.println(
						"###\n  # setDelay ERROR: setting the delay value greater than the total length  is not allowed."
								+ "\n  # please set a value lower than " + this.totalLength + ".\n###");
			return;
		}
	}

	/**
	 * Gets the delay of the easing motion. The delay is the time before the motion
	 * starts.
	 *
	 * @return The delay of the easing motion.
	 */
	public float getDelay() {
		return this.delay;
	}

	/**
	 * Gets the internal counter of the easing motion in frames.
	 *
	 * @return The internal counter of the easing motion in frames.
	 */
	public float getCount() {
		return (this.count + 1) % (this.totalLength * this.motionFrameRate);
	}

	/**
	 * Set the internal counter back to 0.
	 *
	 */
	public void resetCounter() {
		this.count = 0f;
	}

	/**
	 * converts the input value dividing it by the current frameRate.
	 *
	 * @param input the frameCount that should be converted
	 * @return The converted frameCount value .
	 */
	public float framer(float input) {
		return (float) (input / this.motionFrameRate);
	}

	/**
	 * Set the log boolean true or false.
	 *
	 * @param option can be set to true or false
	 */
	public void setLog(Boolean option) {
		this.log = option ? true : !option ? false : this.log;
		String result = option ? "Logs will be shown as desired" : "Setter logs will be no longer displayed";
		System.out.println(result);

	}

	///////////////////////////////////////////////////
	// Utility Functions
	///////////////////////////////////////////////////
	// constrain
	/**
	 * Constrains a value to be within a specified range.
	 *
	 * @param value The value to be constrained.
	 * @param min   The minimum value of the range.
	 * @param max   The maximum value of the range.
	 * @return The constrained value within the specified range.
	 */
	public static float constrain(float value, float min, float max) {
		return Math.min(Math.max(value, min), max);
	}

	// normalize
	/**
	 * Normalizes a value to be within a specified range.
	 *
	 * @param value The value to be normalized.
	 * @param start The start of the range.
	 * @param stop  The end of the range.
	 * @return The normalized value within the specified range.
	 */
	public static float normalize(float value, float start, float stop) {
		return (value - start) / (stop - start);
	}

	// reMap
	/**
	 * maps the input value from the input range (start1 to stop1 to the output
	 * range (start2 to stop2).
	 * 
	 * @param value:  the value to be mapped.
	 * @param start1: the lower bound of the input range.
	 * @param stop1:  the upper bound of the input range.
	 * @param start2: the lower bound of the output range.
	 * @param stop2:  the upper bound of the output range.
	 * @return The remapped value from the input range to the output range.
	 */
	public static float reMap(float value, float start1, float stop1, float start2, float stop2) {
		// Map the value from the input range to the output range
		return start2 + (value - start1) * (stop2 - start2) / (stop1 - start1);
	}

	// saw-tooth-wave
	/**
	 * Generates a sawtooth wave and returns linear values between 0 and 1 based on
	 * the provided time.
	 *
	 * @param time The time value.
	 * @return The value of the sawtooth wave.
	 */
	public static float sawWave(float time) {
		float phase = (time % 1);
		float saw = (phase <= 0.5 ? phase : 1 - phase) * 2;
		return saw * 0.9999f;
	}

	// counter
	/**
	 * Updates the count based on the specified motion type, current count, and
	 * delay.
	 *
	 * @param type  The type of motion ("loop", "alternate", or "static").
	 * @param ct    The current count value.
	 * @param delay The delay for the motion.
	 * @return The normalized count based on the specified motion type and delay.
	 */
	public float counter(float ct, float delay, String type) {

		float valueToReturn = ct;
		switch (type) {

		case "loop-controlled":

			valueToReturn = (ct / this.motionFrameRate - delay) % this.totalLength;
			break;

		case "loop-automated":
			this.count += (this.step * this.motionFrameRate);
			if (this.count >= ((this.totalLength) * this.motionFrameRate) - this.step) {
				this.count = 0f;
			}
			valueToReturn = (this.count / this.motionFrameRate - delay);

			break;
		////// what about the delay here?
		case "alternate-controlled":
			valueToReturn = (sawWave((ct / (this.motionFrameRate * 2)) / (this.totalLength)) * this.totalLength - delay)
					% this.totalLength;
			break;
		////// what about the delay here?

		case "alternate-automated":
			this.count += (this.step * this.motionFrameRate);
			valueToReturn = (sawWave((this.count / this.motionFrameRate) / (2 * this.totalLength)) * this.totalLength
					- delay) % this.totalLength;

			break;

		case "one-repetition-controlled":

			valueToReturn = Math.min((ct / this.motionFrameRate - delay), this.totalLength);
			break;

		case "one-repetition-automated":
			this.count += (step * this.motionFrameRate);

			if (this.count >= ((this.totalLength) * this.motionFrameRate)) {
				this.count = this.totalLength * this.motionFrameRate;
			}
			valueToReturn = Math.min((this.count / this.motionFrameRate - delay), this.totalLength);

			break;

		default:
			valueToReturn = (ct / this.motionFrameRate - delay) % this.totalLength;
			break;
		}

		return valueToReturn;

	}

	///////////////////////////////////////////////////
	// Easing Methods
	///////////////////////////////////////////////////

	//
	//
	//
	/////////////////////////////
	/////////// IN - EXPO
	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Calculates the easing progress using the ease-in-exponential algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float in(float inputCt, float start, float end, String type) {

		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + Math.pow(progress, ex) * (end - start));
	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - EXPO
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-exponential algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float out(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (end - Math.pow(1 - progress, ex) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - OUT - EXPO
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-exponential algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOut(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - SINE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-sine algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inSine(float inputCt, float start, float end, String type) {
		float ex = Math.abs(this.expIntensity) >= 1 ? reMap(this.expIntensity, 1f, 20f, 1f, 4f)
				: Math.abs(this.expIntensity);
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + (1 - Math.cos(progress * Math.PI * 0.5 * ex)) * (end - start));
	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - SINE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-sine algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float outSine(float inputCt, float start, float end, String type) {
		float ex = Math.abs(this.expIntensity) >= 1 ? reMap(this.expIntensity, 1f, 20f, 1f, 4f)
				: Math.abs(this.expIntensity);
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + Math.sin(progress * Math.PI * 0.5 * ex) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - OUT - SINE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-sine algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOutSine(float inputCt, float start, float end, String type) {
		float ex = Math.abs(this.expIntensity) >= 1 ? reMap(this.expIntensity, 1f, 20f, 1f, 4f)
				: Math.abs(this.expIntensity);
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + ((1 - Math.cos(progress * Math.PI * ex)) / 2) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - CIRC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-circ algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inCirc(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + (1 - Math.sqrt(1 - Math.pow(progress, Math.abs(ex * 2)))) * (end - start));
	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - CIRC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-circ algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float outCirc(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + Math.sqrt(1 - Math.pow(progress - 1, Math.abs(ex * 2))) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - OUT - CIRC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-circ algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOutCirc(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) ((progress < 0.5)
				? start + ((1 - Math.sqrt(1 - Math.pow(2 * progress, Math.abs(ex * 2)))) * (end - start)) / 2
				: start + ((Math.sqrt(1 - Math.pow(-2 * progress + 2, Math.abs(ex * 2))) + 1) * (end - start)) / 2);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 7
	//
	//
	//
	/////////////////////////////
	/////////// IN - BACK
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-back algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inBack(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + (c3 * Math.pow(progress, 3) - c1 * Math.pow(progress, 2)) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - BACK
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-back algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float outBack(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (start + (1 + c3 * Math.pow(progress - 1, 3) + c1 * Math.pow(progress - 1, 2)) * (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// IN - OUT - BACK
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-back algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOutBack(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) (progress < 0.5
				? (2 * start + Math.pow(2 * progress, 2) * ((c2 + 1) * 2 * progress - c2) * (end - start)) / 2
				: (2 * start
						+ (Math.pow(2 * progress - 2, 2) * ((c2 + 1) * (progress * 2 - 2) + c2) + 2) * (end - start))
						/ 2);

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 7
	//
	//
	//
	/////////////////////////////
	/////////// IN - ELASTIC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-elastic algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inElastic(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) ((progress == 0) ? start
				: (progress == 1) ? end
						: start - Math.pow(2, 10 * progress - 10) * Math.sin((progress * 10 - 10.75) * c4)
								* (end - start));

	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - ELASTIC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-elastic algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float outElastic(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) ((progress == 0) ? start
				: (progress == 1) ? end
						: start + (Math.pow(2, -10 * progress) * Math.sin((progress * 10 - 0.75) * c4) + 1)
								* (end - start));

	}

	//
	//
	//
	/////////////////////////////
	///////// IN - OUT - ELASTIC
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-elastic algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOutElastic(float inputCt, float start, float end, String type) {
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) ((progress == 0) ? start
				: (progress == 1) ? end
						: (progress < 0.5)
								? start - (Math.pow(2, 20 * progress - 10) * Math.sin((20 * progress - 11.125) * c5)
										* (end - start)) / 2
								: start + ((Math.pow(2, -20 * progress + 10) * Math.sin((20 * progress - 11.125) * c5))
										/ 2 + 1) * (end - start));

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 7
	//
	//
	//
	/////////////////////////////
	/////////// IN - BOUNCE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-Bounce algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inBounce(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return end - bounce(1 - progress, ex) * (end - start);

	}

	//
	//
	//
	/////////////////////////////
	/////////// OUT - BOUNCE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-out-Bounce algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float outBounce(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return start + bounce(progress, ex) * (end - start);

	}

	//
	//
	//
	/////////////////////////////
	///////// IN - OUT - BOUNCE
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Calculates the easing progress using the ease-in-out-Bounce algorithm.
	 *
	 * @param inputCt The input value between 0 and 1, represents the progress of
	 *                the motion.
	 * @param start   The start value.
	 * @param end     The end value.
	 * @param type    Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public final float inOutBounce(float inputCt, float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(inputCt * this.motionFrameRate, this.delay, type);
		float progress = normalize(constrain(ct, 0, this.span), 0, this.span);
		return (float) ((progress < 0.5) ? end - (0.5 + bounce(1 - progress * 2, ex) * 0.5) * (end - start)
				: start + (1 + bounce(2 * progress - 1, ex)) * (end - start) * 0.5);

	}

	/////////////////////////////////////////////////////////////
	///////// Bounce Helper Function
	private static float bounce(float t, float ex) {
		if (t < 1 / 2.75) {
			return (float) (7.5625 * t * t);
		} else if (t < 2 / 2.75) {
			return (float) (7.5625 * (t -= 1.5 / 2.75) * t + 0.75);
		} else if (t < 2.5 / 2.75) {
			return (float) (7.5625 * (t -= 2.25 / 2.75) * t + 0.9375);
		} else {
			return (float) (7.5625 * (t -= 2.625 / 2.75) * t + 0.984375);
		}
	}

}
