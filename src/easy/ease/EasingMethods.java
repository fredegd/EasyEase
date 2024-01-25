package easy.ease;

/**
 * EasingMethods class provides methods for easing motion computations. It
 * encapsulates parameters and methods related to easing functions.
 */
public class EasingMethods {

	private float motionFrameRate;
	private float step;
	private float expIntensity;
	private float totalLength;
	private float delay;
	private float span;
	private float count = 0;

	/**
	 * Constructs an instance of the EasingMethods class with specified parameters.
	 *
	 * @param motionFrameRate The frame rate for motion.
	 * @param expIntensity    The intensity/exponent value for easing.
	 * @param totalLength     The total length of the easing motion.
	 * @param span            The span of the easing motion.
	 * @param delay           The delay before the easing motion starts.
	 */
	public EasingMethods(float motionFrameRate, float expIntensity, float totalLength, float span, float delay) {
		this.motionFrameRate = motionFrameRate;
		this.expIntensity = expIntensity;
		this.totalLength = totalLength;
		this.delay = delay;
		this.span = span;
		this.step = 1f / motionFrameRate;
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
		this.step = 1 / frt;
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
		System.out.println("Curve intensity set to " + this.expIntensity + "sec.");
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
			System.out.println("### \n  # setSpan WARNING: a total Length of " + this.totalLength + " sec.\n"
					+ "  # and a delay of " + this.delay + " sec. has been set.  \n"
					+ "  # Currently, the max. allowed Motion span is " + ref + " sec.\n###");
			this.span = ref;
		} else if (length <= ref) {
			this.span = length;
		}
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
		System.out.println("Delay is now set to " + this.delay + " sec.");
		if (amt > ref) {
			System.out.println("###\n  # setDelay WARNING: setting " + amt + " seconds delay, will \n"
					+ "  # shorten the max allowed Motion span to " + newSpan + " sec.\n###");
			this.span = newSpan;
		}

		if (amt > this.totalLength) {

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
	 * Gets the current count of the easing motion in frames.
	 *
	 * @return The current count of the easing motion in frames.
	 */
	public float getCount() {
		return this.count;
	}

	///////////////////////////////////////////////////
	// Helper Functions
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
	public static float norm(float value, float start, float stop) {
		return (value - start) / (stop - start);
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
	public float counter(String type, float ct, float delay) {
		switch (type) {

		case "loop":
			if (this.count >= (this.totalLength * this.motionFrameRate)) {

				this.count = 0;
			}
			this.count += (step * motionFrameRate);
			break;

		case "alternate":
			if (this.count > (this.totalLength * this.motionFrameRate)) {
				step = Math.abs(step) * -1;
			} else if (this.count < 0) {
				this.delay = delay;
				step = Math.abs(step);
			}
			this.count += (step * motionFrameRate);
			break;

		case "static":
			this.count = ct;
			break;
		}

		return (float) (this.count / this.motionFrameRate - delay);

	}

	///////////////////////////////////////////////////
	// Easing Methods
	///////////////////////////////////////////////////
	/// IN-OUT-EXPO
	/**
	 * Calculates the easing progress using the in-out-exponential easing algorithm.
	 *
	 * @param start The start value.
	 * @param end   The end value.
	 * @return The eased progress between start and end.
	 */
	public float inOut(float start, float end) {
		String type = "loop";
		float ex = this.expIntensity;
		float ct = counter(type, 0, this.delay);
		float progress = norm(constrain(((float) (ct)), 0, this.span), 0, this.span);
		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}

	/**
	 * Calculates the easing progress using the in-out-exponential easing algorithm.
	 *
	 * @param start The start value.
	 * @param end   The end value.
	 * @param type  Which kind of motion
	 * @return The eased progress between start and end.
	 */
	public float inOut(float start, float end, String type) {
		float ex = this.expIntensity;
		float ct = counter(type, 0, this.delay);
		float progress = norm(constrain(((float) (ct)), 0, this.span), 0, this.span);
		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}

	/**
	 * Computes an easing-in-out motion based on the specified input value.
	 *
	 * @param inputCt The input value between 0 and 1, representing the progress of
	 *                the motion.
	 * @return The result of the easing-in-out motion computation.
	 */
	public float inOut(float inputCt) {
		String type = "static";// default
		float ex = this.expIntensity;

		float start = 0f;
		float end = 1f;
		float ct = counter(type, inputCt * this.motionFrameRate, this.delay);
		float progress = norm(constrain(((float) (ct)), 0, this.span), 0, this.span);
		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}
}
