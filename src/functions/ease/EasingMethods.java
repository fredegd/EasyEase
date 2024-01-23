package functions.ease;

public class EasingMethods {

	// Variables related to easing
	private float currentFrameRate;
	private float step;
	private float totalLength;
	private float delay;
	private float span;
	public float count = 0;

	public EasingMethods(float currentFrameRate, float totalLength, float span, float delay) {
		this.currentFrameRate = currentFrameRate;
		this.totalLength = totalLength;
		this.delay = delay;
		this.span = totalLength - delay;
		this.step = 1 / currentFrameRate;
	}

	// Getters and Setters for easing-related variables
	public void setFrameRate(float frt) {
		currentFrameRate = frt;
		step = 1 / frt;
		System.out.println("Motion Framerate set to " + currentFrameRate + "fps");
	}

	public float getFrameRate() {
		System.out.println("Current Motion Framerate: " + this.currentFrameRate + "fps");
		return this.currentFrameRate;
	}

	public void setTotalLength(float length) {
		this.totalLength = length;
		this.span = this.totalLength - this.delay;
		System.out.println("Total length set to " + this.totalLength + "seconds");
	}

	public float getTotalLength() {
		System.out.println("Total length: " + this.totalLength + "seconds");
		return this.totalLength;
	}
	 public void setSpan(float length) {
			
	 if (length > this.totalLength) {
	 System.out.println("Animation span cannot exceed Total Animation Length");
	 System.out.println("Animation span is now set to " + this.totalLength +
	 "seconds");
	 this.span = this.totalLength;
	 } else if (length <= this.totalLength) {
	 this.span = length;
	 }
	
	 System.out.println("Animation span is now set to " + this.span + "seconds");
	 }
	
	 public float getSpan() {
	 System.out.println("Animation span: " + this.span + "seconds");
	 return this.span;
	 }

	public void setDelay(float amt) {
		this.delay = amt;
		System.out.println("Delay set to " + this.delay + " seconds");
	}

	public float getDelay() {
		System.out.println("Delay: " + delay + "seconds");
		return this.delay;
	}

	//
	//
	//
	// helper functions:
	// constrain
	public static float constrain(float value, float min, float max) {
		return Math.min(Math.max(value, min), max);
	}

	// normalize
	public static float norm(float value, float start, float stop) {
		return (value - start) / (stop - start);
	}

	// counter
	public float counter(String type, float ct) {
		switch (type) {
		case "static":
			this.count = ct;
			break;
		case "loop":
			if (this.count >= (this.totalLength * this.currentFrameRate)) {
				this.count = 0;
			}
			this.count += (step * currentFrameRate);
			break;

		case "alternate":
			if (this.count > (this.totalLength * this.currentFrameRate)) {
				step = Math.abs(step) * -1;
			} else if (this.count < 0) {
				step = Math.abs(step);
			}
			this.count += (step * currentFrameRate);
			break;
		}

		return this.count;
	}

	// Easing methods
	///IN-OUT-EXPO
	public float inOut(float ex, float start, float end) {
		String type = "loop";// default
		float ct = counter(type, 0);
		float progress = norm(constrain(((float) (ct / this.currentFrameRate) - this.delay), 0, this.span), 0,
				this.span);

		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}

	public float inOut(float ex, float start, float end, String type) {
		float ct = counter(type, 0);
		float progress = norm(constrain(((float) (ct / this.currentFrameRate) - delay), 0, this.span), 0, this.span);

		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}

	// inputCt receives a value between 0 and 1 by default
	public float inOut(float ex, float inputCt) {
		String type = "static";// default
		float ct = counter(type, inputCt);
		float start = 0f;
		float end = 1f;
		float progress = norm(constrain((ct - delay), 0, this.span), 0, this.span);
		return (float) (progress < 0.5 ? start + Math.pow(2, ex - 1) * Math.pow(progress, ex) * (end - start)
				: start + (1 - Math.pow(2 - progress * 2, ex) / 2) * (end - start));
	}
}
