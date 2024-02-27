package easy.ease;

import processing.core.*;

/**
 * EasyEase class provides an interface for easing motion using various
 * algorithms. It encapsulates parameters and methods related to easing curve
 * calculations and related functionalities.
 */
public class EasyEase {

	// sketch is a reference to the parent sketch
	/**
	 * @see sketch The parent PApplet.
	 */
	PApplet sketch;
	/**
	 * @see EasingMethods generator an instance of the easing methods Class
	 */
	private EasingMethods generator;
	/**
	 * @see motionFrameRate The default frame rate value for motion calculations
	 */
	public float motionFrameRate = 60f; /////////////// default value like default frameRate
	/**
	 * @see step the value which gets added to the counter at each frame
	 */
	public float step = 1 / motionFrameRate;////////////////////////////// default value 1/60
	/**
	 * @see totalLength The maximum and total length of the easing motion
	 */
	public float totalLength = 1.0f; ///////////////////////////////// default value 1 second.
	/**
	 * @see delay The delay in seconds before the easing motion starts.
	 */
	public float delay = 0.0f; ////////////////////////////////////// default value: 0 second.
	/**
	 * @see span The span of the easing motion. without the delay
	 */
	public float span = totalLength - delay; //////////////////////// default value: 1 second.
	/**
	 * @see expIntensity The value of the intensity factor
	 */
	public float expIntensity = 1.0f; /////////////////////////////// default factor value: 1

	private final float defaultStart = 0f;/////////////////////////// default factor value: 0

	private final float defaultEnd = 1f;///////////////////////////// default factor value: 1

	private final float defaultCountStart = 0;/////////////////////// default factor value: 1
	/**
	 * @version VERSION the current version of this library
	 */
	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * 3rd Constructor Constructs an instance of the EasyEase class with specified
	 * parameters.
	 * 
	 * @param theSketch    The parent PApplet.
	 * @param expIntensity The intensity/exponent value of the easing curve.
	 * @param totalLength  The maximum and total length of the easing motion
	 * @param span         The span of the easing motion.
	 * @param delay        The delay before the easing motion starts.
	 */
	public EasyEase(PApplet theSketch, float expIntensity, float totalLength, float span, float delay) {
		init(theSketch);
		generator = new EasingMethods(expIntensity, totalLength, span, delay, this.motionFrameRate);
	}

	/**
	 * 2nd Constructor Constructs an instance of the EasyEase class with a specified
	 * exponent/intensity value.
	 * 
	 * @param theSketch    The parent PApplet.
	 * @param expIntensity The intensity/exponent value of the easing curve.
	 */
	public EasyEase(PApplet theSketch, float expIntensity) {
		init(theSketch);
		generator = new EasingMethods(expIntensity, this.totalLength, this.span, this.delay, this.motionFrameRate);

	}

	/**
	 * 1st Constructor Constructs an instance of the EasyEase class with default
	 * parameters.
	 * 
	 * @param theSketch The parent PApplet.
	 */
	public EasyEase(PApplet theSketch) {
		init(theSketch);
		generator = new EasingMethods(1f, this.totalLength, this.span, this.delay, this.motionFrameRate);

	}

	/**
	 * Prints a welcome message to the console with library information.
	 */
	private static void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	/**
	 * Initializes the EasyEase instance with the provided PApplet reference and
	 * sets the motion frame rate.
	 *
	 * @param theSketch The parent PApplet reference.
	 */
	private void init(PApplet theSketch) {
		sketch = theSketch;
		this.motionFrameRate = sketch.frameRate;
	}

	/**
	 * Returns the version of the EasyEase library.
	 *
	 * @return String representing the library version.
	 */

	public static String version() {
		return VERSION;
	}

	/**
	 * Print the welcome message and some other library info to the console
	 *
	 * 
	 */

	public static void getInfo() {
		welcome();

	}

	/**
	 * Sets the motion frame rate for the easing methods.
	 *
	 * @param frt The new motion frame rate value.
	 */
	public void setFrameRate(float frt) {
		generator.setFrameRate(frt);
	}

	/**
	 * Returns the current motion frame rate used by the easing methods.
	 *
	 * @return The current motion frame rate.
	 */
	public float getFrameRate() {
		return generator.getFrameRate();
	}

	/**
	 * Sets the intensity/exponent value for easing.
	 *
	 * @param expVal The new intensity/exponent value.
	 */
	public void setIntensity(float expVal) {
		generator.setIntensity(expVal);
	}

	/**
	 * Returns the current intensity/exponent value used for easing.
	 *
	 * @return The current intensity/exponent value.
	 */
	public float getIntensity() {
		return generator.getIntensity();
	}

	/**
	 * Sets the total length of the easing motion.
	 *
	 * @param length The new total length value.
	 */
	public void setTotalLength(float length) {
		generator.setTotalLength(length);
	}

	/**
	 * Returns the current total length of the easing motion.
	 *
	 * @return The current total length.
	 */
	public float getTotalLength() {
		return generator.getTotalLength();
	}

	/**
	 * Sets the span of the easing motion.
	 *
	 * @param amt The new span value.
	 */
	public void setSpan(float amt) {
		generator.setSpan(amt);
	}

	/**
	 * Returns the current span of the easing motion.
	 *
	 * @return The current span.
	 */
	public float getSpan() {
		return generator.getSpan();

	}

	/**
	 * Sets the delay before the easing motion starts.
	 *
	 * @param amt The new delay value.
	 */
	public void setDelay(float amt) {
		generator.setDelay(amt);
	}

	/**
	 * Returns the current delay before the easing motion starts.
	 *
	 * @return The current delay.
	 */
	public float getDelay() {
		return generator.getDelay();

	}

	/**
	 * Returns the internal counter of the motion .
	 *
	 * @return The current counter value .
	 */
	public float getCounter() {
		return generator.getCount();
	}

	/**
	 * Set the internal counter of the motion.
	 *
	 */

	public void resetCounter() {
		generator.resetCounter();
	}

	/**
	 * Returns the input frameCount divided by the current frameRate.
	 *
	 * @param input the frameCount that should be converted
	 * @return The converted frameCount value .
	 */
	public float framer(float input) {
		return generator.framer(input);
	}

	/**
	 * Set the log boolean true or false.
	 *
	 * @param option can be set to true or false
	 */
	public void setLog(Boolean option) {
		generator.setLog(option);
	}

	/////////////////////////////
	// EASING METHODS:
	/////////////////////////////
	/////////////////////////////
	//
	//
	//
	//
	//
/////////////////////////////
/////////// IN - EXPO
//
// controlled counter
////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * returns a linear value between start and end
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float linear(float inputCt) {
		return generator.linear(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * returns a linear value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The easing type.
	 * @return The eased value.
	 */
	public float linear(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.linear(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * returns a linear value between start and end
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float linear(float inputCt, float start, float end) {
		return generator.linear(inputCt, start, end, "loop-controlled");
	}

	/**
	 * returns a linear value between start and end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float linear(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.linear(inputCt, start, end, check);
	}
// automated counter
////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * returns a linear value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float linear(float start, float end) {
		return generator.linear(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * returns a linear value between start and end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float linear(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.linear(defaultCountStart, start, end, check);
	}

	/////////////////////////////
	/////////// IN - EXPO
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the in easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float in(float inputCt) {
		return generator.in(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the in easing method to calculate a value between 0 and 1 based on
	 * the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The easing type.
	 * @return The eased value.
	 */
	public float in(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.in(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float in(float inputCt, float start, float end) {
		return generator.in(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the in easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float in(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.in(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float in(float start, float end) {
		return generator.in(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the in easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float in(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.in(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - EXPO
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the out easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float out(float inputCt) {
		return generator.out(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the out easing method to calculate a value between 0 and 1 based on
	 * the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float out(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.out(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the out easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float out(float inputCt, float start, float end) {
		return generator.out(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the out easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float out(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.out(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the out easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float out(float start, float end) {
		return generator.out(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the out easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float out(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.out(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - EXPO
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOut easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOut(float inputCt) {
		return generator.inOut(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOut easing method to calculate a value between 0 and 1 based on
	 * the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOut(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOut(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOut easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOut(float inputCt, float start, float end) {
		return generator.inOut(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOut easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOut(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOut(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOut easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOut(float start, float end) {
		return generator.inOut(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOut easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOut(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOut(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN - SINE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inSine easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inSine(float inputCt) {
		return generator.inSine(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inSine easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inSine(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inSine(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inSine easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inSine(float inputCt, float start, float end) {
		return generator.inSine(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inSine easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inSine(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inSine(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inSine(float start, float end) {
		return generator.inSine(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inSine easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inSine(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inSine(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - SINE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outSine easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float outSine(float inputCt) {
		return generator.outSine(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the outSine easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outSine(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outSine(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the outSine easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float outSine(float inputCt, float start, float end) {
		return generator.outSine(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the outSine easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outSine(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outSine(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outSine easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float outSine(float start, float end) {
		return generator.outSine(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the outSine easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float outSine(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.outSine(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN-OUT - SINE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutSine easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOutSine(float inputCt) {
		return generator.inOutSine(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOutSine easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutSine(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutSine(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOutSine easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOutSine(float inputCt, float start, float end) {
		return generator.inOutSine(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOutSine easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutSine(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutSine(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutSine easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOutSine(float start, float end) {
		return generator.inOutSine(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOutSine easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOutSine(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOutSine(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN - CIRC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inCirc easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inCirc(float inputCt) {
		return generator.inCirc(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inCirc easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inCirc(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inCirc(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inCirc easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inCirc(float inputCt, float start, float end) {
		return generator.inCirc(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inCirc easing method to calculate a value between start and end
	 * with a specified type.
	 * 
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inCirc(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inCirc(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inCirc(float start, float end) {
		return generator.inCirc(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inCirc easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inCirc(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inCirc(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - CIRC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outCirc easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float outCirc(float inputCt) {
		return generator.outCirc(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the outCirc easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outCirc(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outCirc(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the outCirc easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float outCirc(float inputCt, float start, float end) {
		return generator.outCirc(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the outCirc easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outCirc(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outCirc(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outCirc easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float outCirc(float start, float end) {
		return generator.outCirc(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the outCirc easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float outCirc(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.outCirc(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN-OUT - CIRC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutCirc easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOutCirc(float inputCt) {
		return generator.inOutCirc(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOutCirc easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutCirc(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutCirc(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOutCirc easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOutCirc(float inputCt, float start, float end) {
		return generator.inOutCirc(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOutCirc easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutCirc(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutCirc(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutCirc easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOutCirc(float start, float end) {
		return generator.inOutCirc(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOutCirc easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOutCirc(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOutCirc(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN - BACK
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inBack easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inBack(float inputCt) {
		return generator.inBack(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inBack easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inBack(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inBack(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inBack easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inBack(float inputCt, float start, float end) {
		return generator.inBack(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inBack easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inBack(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inBack(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inBack(float start, float end) {
		return generator.inBack(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inBack easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inBack(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inBack(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - BACK
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outBack easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float outBack(float inputCt) {
		return generator.outBack(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the outBack easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outBack(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outBack(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the outBack easing method to calculate a value between start and end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float outBack(float inputCt, float start, float end) {
		return generator.outBack(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the outBack easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outBack(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outBack(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outBack easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float outBack(float start, float end) {
		return generator.outBack(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the outBack easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float outBack(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.outBack(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN-OUT - BACK
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutBack easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOutBack(float inputCt) {
		return generator.inOutBack(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOutBack easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutBack(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutBack(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOutBack easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOutBack(float inputCt, float start, float end) {
		return generator.inOutBack(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOutBack easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutBack(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutBack(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutBack easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOutBack(float start, float end) {
		return generator.inOutBack(defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOutBack easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOutBack(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOutBack(defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN - ELASTIC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inElastic easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inElastic(float inputCt) {
		return generator.inElastic(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inElastic easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inElastic(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inElastic(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inElastic easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inElastic(float inputCt, float start, float end) {
		return generator.inElastic(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inElastic(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inElastic(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inElastic(float start, float end) {
		return generator.inElastic(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inElastic(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inElastic(this.defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - ELASTIC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outElastic easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float outElastic(float inputCt) {
		return generator.outElastic(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the outElastic easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outElastic(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outElastic(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the outElastic easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float outElastic(float inputCt, float start, float end) {
		return generator.outElastic(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the outElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outElastic(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outElastic(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outElastic easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float outElastic(float start, float end) {
		return generator.outElastic(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the outElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float outElastic(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.outElastic(this.defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN-OUT - ELASTIC
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutElastic easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOutElastic(float inputCt) {
		return generator.inOutElastic(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOutElastic easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutElastic(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutElastic(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOutElastic easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOutElastic(float inputCt, float start, float end) {
		return generator.inOutElastic(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOutElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutElastic(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutElastic(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutElastic easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOutElastic(float start, float end) {
		return generator.inOutElastic(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOutElastic easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOutElastic(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOutElastic(this.defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN - BOUNCE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inBounce easing method to calculate a value between 0 and 1 based
	 * on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inBounce(float inputCt) {
		return generator.inBounce(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inBounce easing method to calculate a value between 0 and 1 based
	 * on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inBounce(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inBounce(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inBounce easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inBounce(float inputCt, float start, float end) {
		return generator.inBounce(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inBounce easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inBounce(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inBounce(inputCt, start, end, check);
	}
	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inBounce(float start, float end) {
		return generator.inBounce(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inBounce easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inBounce(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inBounce(this.defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// OUT - BOUNCE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outBounce easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float outBounce(float inputCt) {
		return generator.outBounce(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the outBounce easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outBounce(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outBounce(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the outBounce easing method to calculate a value between start and
	 * end.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float outBounce(float inputCt, float start, float end) {
		return generator.outBounce(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the outBounce easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float outBounce(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.outBounce(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the outBounce easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float outBounce(float start, float end) {
		return generator.outBounce(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the outBounce easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float outBounce(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.outBounce(this.defaultCountStart, start, end, check);
	}

	//
	//
	//
	//
	//
	/////////////////////////////
	/////////// IN-OUT - BOUNCE
	//
	// controlled counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutBounce easing method to calculate a value between 0 and 1
	 * based on the input.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @return The eased value.
	 */
	public float inOutBounce(float inputCt) {
		return generator.inOutBounce(inputCt, defaultStart, defaultEnd, "loop-controlled");
	}

	/**
	 * Applies the inOutBounce easing method to calculate a value between 0 and 1
	 * based on the input and on the specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutBounce(float inputCt, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutBounce(inputCt, defaultStart, defaultEnd, check);

	}

	/**
	 * Applies the inOutBounce easing method to calculate a value between start and
	 * end.
	 * 
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @return The eased value.
	 */
	public float inOutBounce(float inputCt, float start, float end) {
		return generator.inOutBounce(inputCt, start, end, "loop-controlled");
	}

	/**
	 * Applies the inOutBounce easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param inputCt the input progress, a value between 0 and totalLength
	 * @param start   The starting value.
	 * @param end     The ending value.
	 * @param type    The looping options.
	 * @return The eased value.
	 */
	public float inOutBounce(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled"
				: type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.inOutBounce(inputCt, start, end, check);
	}

	// automated counter
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Applies the inOutBounce easing method to calculate a value between start and
	 * end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOutBounce(float start, float end) {
		return generator.inOutBounce(this.defaultCountStart, start, end, "loop-automated");
	}

	/**
	 * Applies the inOutBounce easing method to calculate a value between start and
	 * end with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The looping options.
	 * @return The eased value.
	 */
	public float inOutBounce(float start, float end, String type) {
		String check = type == "loop" ? "loop-automated"
				: type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.inOutBounce(this.defaultCountStart, start, end, check);
	}

}
