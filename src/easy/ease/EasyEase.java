package easy.ease;

import processing.core.*;

/**
 * EasyEase class provides an interface for easing motion using various
 * algorithms. It encapsulates parameters and methods related to easing
 * functionalities.
 */
public class EasyEase {

	// sketch is a reference to the parent sketch
	PApplet sketch;
	public EasingMethods generator;
	public float motionFrameRate = 60f; /////////////// default value like default frameRate
	public float step = 1 / motionFrameRate;////////////////////////////// default value 1/60
	public float totalLength = 1.0f; //////////////////////////////////// default value 1 sec.
	public float delay = 0.0f; //////////////////////////////////////// default value: 0 sec.
	public float span = totalLength - delay; /////////////////////////// default value: 1 sec.
	public float expIntensity = 1.0f; /////////////////////////////// default factor value: 1
	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * 1st Constructor Constructs an instance of the EasyEase class with default
	 * parameters.
	 * 
	 * @param theSketch The parent PApplet.
	 */
	public EasyEase(PApplet theSketch) {
		init(theSketch);
		generator = new EasingMethods(this.expIntensity, this.totalLength, this.span, this.delay, this.motionFrameRate);

	}

	/**
	 * Constructs an instance of the EasyEase class with a specified
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
	 * Constructs an instance of the EasyEase class with specified parameters.
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
	 * Constructs an instance of the EasyEase class with specified parameter
	 * including the global frameRate.
	 * 
	 * @param theSketch    The parent PApplet.
	 * @param expIntensity The intensity/exponent value of the easing curve.
	 * @param totalLength  The maximum and total length of the easing motion
	 * @param span         The span of the easing motion.
	 * @param delay        The delay before the easing motion starts.
	 */
	public EasyEase(PApplet theSketch, float expIntensity, float totalLength, float span, float delay,
			float frameRate) {
		init(theSketch);
		generator = new EasingMethods(expIntensity, totalLength, span, delay, frameRate);
	}

	/**
	 * Prints a welcome message to the console with library information.
	 */
	private void welcome() {
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
	public float getCounter() {
		return generator.getCount();
	}



	public void resetCounter() {
		generator.resetCounter();
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
	/**
	 * Applies the in easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt The input value between 0 and 1.
	 * @return The eased value.
	 */
	public float in(float inputCt) {
		float start = 0f;
		float end = 1f;
		String type = "controlled";// default
		return generator.in(inputCt, start, end, type);
	}

	/**
	 * Applies the in easing method to calculate a value between 0 and 1 based on
	 * the input and on the specified type.
	 *
	 * @param inputCt The input value between 0 and 1.
	 * @return The eased value.
	 */
	public float in(float inputCt, String type) {
		float start = 0f;
		float end = 1f;
		String check = type == "loop" ? "controlled":type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.in(inputCt, start, end, check);

	}
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float in(float inputCt, float start, float end) {
		String type = "loop-controlled";
		return generator.in(inputCt, start, end, type);
	}

	/**
	 * Applies the in easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The easing type.
	 * @return The eased value.
	 */
	public float in(float inputCt, float start, float end, String type) {
		String check = type == "loop" ? "loop-controlled":type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition-controlled" : "";
		return generator.in(inputCt, start, end, check);
	}
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float in(float start, float end) {
		float inputCt = 0f;
		String type = "loop-automated";
		return generator.in(inputCt, start, end, type);
	}

	/**
	 * Applies the in easing method to calculate a value between start and end with
	 * a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The easing type.
	 * @return The eased value.
	 */
	public float in(float start, float end, String type) {
		float inputCt = 0f;
		String check = type == "loop" ? "loop-automated":type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition-automated" : "";
		return generator.in(inputCt, start, end, check);
	}

//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - EXPO
//	/**
//	 * Applies the out easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float out(float start, float end) {
//		String type = "automated";
//		return generator.out(start, end, type);
//	}
//
//	/**
//	 * Applies the out easing method to calculate a value between start and end with
//	 * a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float out(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.out(start, end, check);
//	}
//
//	/**
//	 * Applies the out easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float out(float inputCt) {
//		String type = "controlled";// default
//		return generator.out(inputCt, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float out(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.out(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - EXPO
//	/**
//	 * Applies the inOut easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOut(float start, float end) {
//		String type = "automated";
//		return generator.inOut(start, end, type);
//	}
//
//	/**
//	 * Applies the inOut easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOut(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOut(start, end, check);
//	}
//
//	/**
//	 * Applies the inOut easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOut(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOut(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOut easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOut(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOut(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - SINE
//	/**
//	 * Applies the in easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inSine(float start, float end) {
//		String type = "automated";
//		return generator.inSine(start, end, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between start and end with
//	 * a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inSine(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.inSine(start, end, check);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inSine(float inputCt) {
//		String type = "controlled";// default
//		return generator.inSine(inputCt, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inSine(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inSine(inputCt, check);
//
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - SINE
//	/**
//	 * Applies the out easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float outSine(float start, float end) {
//		String type = "automated";
//		return generator.outSine(start, end, type);
//	}
//
//	/**
//	 * Applies the outSine easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float outSine(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.outSine(start, end, check);
//	}
//
//	/**
//	 * Applies the outSine easing method to calculate a value between 0 and 1 based
//	 * on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outSine(float inputCt) {
//		String type = "controlled";// default
//		return generator.outSine(inputCt, type);
//	}
//
//	/**
//	 * Applies the out-Sine easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outSine(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.outSine(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - SINE
//	/**
//	 * Applies the inOutSine easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOutSine(float start, float end) {
//		String type = "automated";
//		return generator.inOutSine(start, end, type);
//	}
//
//	/**
//	 * Applies the inOutSine easing method to calculate a value between start and
//	 * end with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOutSine(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOutSine(start, end, check);
//	}
//
//	/**
//	 * Applies the inOutSine easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutSine(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOutSine(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOutSine easing method to calculate a value between 0 and 1
//	 * based on the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutSine(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOutSine(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - CIRC
//	/**
//	 * Applies the in-circ easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inCirc(float start, float end) {
//		String type = "automated";
//		return generator.inCirc(start, end, type);
//	}
//
//	/**
//	 * Applies the in-circ easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inCirc(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.inCirc(start, end, check);
//	}
//
//	/**
//	 * Applies the in-circ easing method to calculate a value between 0 and 1 based
//	 * on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inCirc(float inputCt) {
//		String type = "controlled";// default
//		return generator.inCirc(inputCt, type);
//	}
//
//	/**
//	 * Applies the in-circ easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inCirc(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inCirc(inputCt, check);
//
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - CIRC
//	/**
//	 * Applies the Out-Circ easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float outCirc(float start, float end) {
//		String type = "automated";
//		return generator.outCirc(start, end, type);
//	}
//
//	/**
//	 * Applies the Out-Circ easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float outCirc(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.outCirc(start, end, check);
//	}
//
//	/**
//	 * Applies the Out-Circ easing method to calculate a value between 0 and 1 based
//	 * on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outCirc(float inputCt) {
//		String type = "controlled";// default
//		return generator.outCirc(inputCt, type);
//	}
//
//	/**
//	 * Applies the Out-Circ easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outCirc(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.outCirc(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - CIRC
//	/**
//	 * Applies the inOutCirc easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOutCirc(float start, float end) {
//		String type = "automated";
//		return generator.inOutCirc(start, end, type);
//	}
//
//	/**
//	 * Applies the inOutCirc easing method to calculate a value between start and
//	 * end with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOutCirc(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOutCirc(start, end, check);
//	}
//
//	/**
//	 * Applies the inOutCirc easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutCirc(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOutCirc(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOutCirc easing method to calculate a value between 0 and 1
//	 * based on the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutCirc(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOutCirc(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - BACK
//	/**
//	 * Applies the in easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inBack(float start, float end) {
//		String type = "automated";
//		return generator.inBack(start, end, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between start and end with
//	 * a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inBack(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.inBack(start, end, check);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inBack(float inputCt) {
//		String type = "controlled";// default
//		return generator.inBack(inputCt, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inBack(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inBack(inputCt, check);
//
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - BACK
//	/**
//	 * Applies the out easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float outBack(float start, float end) {
//		String type = "automated";
//		return generator.outBack(start, end, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float outBack(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.outBack(start, end, check);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between 0 and 1 based
//	 * on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outBack(float inputCt) {
//		String type = "controlled";// default
//		return generator.outBack(inputCt, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outBack(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.outBack(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - BACK
//	/**
//	 * Applies the inOutBack easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOutBack(float start, float end) {
//		String type = "automated";
//		return generator.inOutBack(start, end, type);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between start and
//	 * end with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOutBack(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOutBack(start, end, check);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutBack(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOutBack(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between 0 and 1
//	 * based on the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutBack(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOutBack(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - ELASTIC
//	/**
//	 * Applies the in easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inElastic(float start, float end) {
//		String type = "automated";
//		return generator.inElastic(start, end, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between start and end with
//	 * a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inElastic(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.inElastic(start, end, check);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inElastic(float inputCt) {
//		String type = "controlled";// default
//		return generator.inElastic(inputCt, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inElastic(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inElastic(inputCt, check);
//
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - ELASTIC
//	/**
//	 * Applies the out easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float outElastic(float start, float end) {
//		String type = "automated";
//		return generator.outElastic(start, end, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float outElastic(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.outElastic(start, end, check);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between 0 and 1 based
//	 * on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outElastic(float inputCt) {
//		String type = "controlled";// default
//		return generator.outElastic(inputCt, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outElastic(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.outElastic(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - ELASTIC
//	/**
//	 * Applies the inOutBack easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOutElastic(float start, float end) {
//		String type = "automated";
//		return generator.inOutElastic(start, end, type);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between start and
//	 * end with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOutElastic(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOutElastic(start, end, check);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutElastic(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOutElastic(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOutBack easing method to calculate a value between 0 and 1
//	 * based on the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutElastic(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOutElastic(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - BACK
//	/**
//	 * Applies the in easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inBounce(float start, float end) {
//		String type = "automated";
//		return generator.inBounce(start, end, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between start and end with
//	 * a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inBounce(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.inBounce(start, end, check);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inBounce(float inputCt) {
//		String type = "controlled";// default
//		return generator.inBounce(inputCt, type);
//	}
//
//	/**
//	 * Applies the in easing method to calculate a value between 0 and 1 based on
//	 * the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inBounce(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inBounce(inputCt, check);
//
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// OUT - BOUNCE
//	/**
//	 * Applies the out easing method to calculate a value between start and end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float outBounce(float start, float end) {
//		String type = "automated";
//		return generator.outBounce(start, end, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between start and end
//	 * with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float outBounce(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//		return generator.outBounce(start, end, check);
//	}
//
//	/**
//	 * Applies the out-Bounce easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outBounce(float inputCt) {
//		String type = "controlled";// default
//		return generator.outBounce(inputCt, type);
//	}
//
//	/**
//	 * Applies the out-Back easing method to calculate a value between 0 and 1 based
//	 * on the input and on the specified type.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float outBounce(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.outBounce(inputCt, check);
//	}
//
//	//
//	//
//	//
//	//
//	//
//	/////////////////////////////
//	/////////// IN - OUT - BOUNCE
//	/**
//	 * Applies the inOutBack easing method to calculate a value between start and
//	 * end.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @return The eased value.
//	 */
//	public float inOutBounce(float start, float end) {
//		String type = "automated";
//		return generator.inOutBounce(start, end, type);
//	}
//
//	/**
//	 * Applies the inOutBounce easing method to calculate a value between start and
//	 * end with a specified type.
//	 *
//	 * @param start The starting value.
//	 * @param end   The ending value.
//	 * @param type  The easing type.
//	 * @return The eased value.
//	 */
//	public float inOutBounce(float start, float end, String type) {
//		String check = type == "alternate" ? "alternate-automated" : type == "once" ? "one-repetition" : "";
//
//		return generator.inOutBounce(start, end, check);
//	}
//
//	/**
//	 * Applies the inOutBounce easing method to calculate a value between 0 and 1
//	 * based on the input.
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutBounce(float inputCt) {
//		String type = "controlled";// default
//		return generator.inOutBounce(inputCt, type);
//	}
//
//	/**
//	 * Applies the inOutBounce easing method to calculate a value between 0 and 1
//	 * based on the input and on the specified type
//	 *
//	 * @param inputCt The input value between 0 and 1.
//	 * @return The eased value.
//	 */
//	public float inOutBounce(float inputCt, String type) {
//		String check = type == "alternate" ? "alternate-controlled" : type == "once" ? "one-repetition" : "";
//		return generator.inOutBounce(inputCt, check);
//	}

}
