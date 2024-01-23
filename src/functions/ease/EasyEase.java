package functions.ease;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package
 * 'template' to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class EasyEase {

	// sketch is a reference to the parent sketch
	PApplet sketch;
	EasingMethods generator;
	public float currentFrameRate = 60f; // default value like default frameRate
	public float step = 1 / currentFrameRate;
	public float totalLength = 1.0f;
	public float delay = 0.0f;
	public float span = totalLength - delay;
	// public String typeStr = "inOutCirc";
	public float exVal = 4.0f;
	public float count = 0;
	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @example Hello
	 * @param theSketch the parent PApplet
	 */
	//
	// no parameter
	public EasyEase(PApplet theSketch) {
		sketch = theSketch;
		generator = new EasingMethods(this.currentFrameRate, this.totalLength, this.span, this.delay);
	}

	//
	// framerate totalLength,span,delay
	public EasyEase(PApplet theSketch, float frameRate, float totalLength, float span, float delay) {
		sketch = theSketch;
		generator = new EasingMethods(frameRate, totalLength, span, delay);
	}

	// private void welcome() {
	// System.out.println("##library.name## ##library.prettyVersion## by
	// ##author##");
	// setFrameRate(sketch.frameRate);
	// }
	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	public void setFrameRate(float frt) {
		generator.setFrameRate(frt);
	}

	public float getFrameRate() {
		return generator.getFrameRate();
	}

	public void setTotalLength(float length) {
		generator.setTotalLength(length);
	}

	public float getTotalLength() {
		return generator.getTotalLength();
	}

	public void setSpan(float amt) {
		generator.setSpan(amt);
	}

	public float getSpan() {
		return generator.getSpan();

	}

	public void setDelay(float amt) {
		generator.setDelay(amt);
	}

	public float getDelay() {
		return generator.getDelay();

	}

	/////////////
	// EASING METHODS:
	////////////

	public float inOut(float ex, float start, float end) {
		return generator.inOut(ex, start, end);
	}

	// expoVal, start,end
	public float inOut(float ex, float start, float end, String type) {
		return generator.inOut(ex, start, end, type);
	}

	// inputCt receives a value between 0 and 1 by default
	public float inOut(float ex, float inputCt) {
		return generator.inOut(ex, inputCt);
	}
}
