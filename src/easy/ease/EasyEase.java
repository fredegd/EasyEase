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

	////////////////////
	// EASING METHODS:
	////////////////////
	////////////////////

	/////////// IN - EXPO
	/**
	 * Applies the in easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float in(float start, float end) {
		return generator.in(start, end);
	}

	/**
	 * Applies the in easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The easing type.
	 * @return The eased value.
	 */
	public float in(float start, float end, String type) {
		return generator.in(start, end, type);
	}

	/**
	 * Applies the in easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt The input value between 0 and 1.
	 * @return The eased value.
	 */
	public float in(float inputCt) {
		return generator.in(inputCt);
	}
	

	/////////// OUT - EXPO
	/**
	 * Applies the out easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float out(float start, float end) {
		return generator.out(start, end);
	}

	/**
	 * Applies the out easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The easing type.
	 * @return The eased value.
	 */
	public float out(float start, float end, String type) {
		return generator.out(start, end, type);
	}

	/**
	 * Applies the out easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt The input value between 0 and 1.
	 * @return The eased value.
	 */
	public float out(float inputCt) {
		return generator.out(inputCt);
	}
	
	
	
	/////////// IN - OUT - EXPO
	/**
	 * Applies the inOut easing method to calculate a value between start and end.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @return The eased value.
	 */
	public float inOut(float start, float end) {
		return generator.inOut(start, end);
	}

	/**
	 * Applies the inOut easing method to calculate a value between start and end
	 * with a specified type.
	 *
	 * @param start The starting value.
	 * @param end   The ending value.
	 * @param type  The easing type.
	 * @return The eased value.
	 */
	public float inOut(float start, float end, String type) {
		return generator.inOut(start, end, type);
	}

	/**
	 * Applies the inOut easing method to calculate a value between 0 and 1 based on
	 * the input.
	 *
	 * @param inputCt The input value between 0 and 1.
	 * @return The eased value.
	 */
	public float inOut(float inputCt) {
		return generator.inOut(inputCt);
	}
}
