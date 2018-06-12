package com.legyver.blog.powerenum;

public enum LightStateAsEnum implements LightState {
	ON("Lights are on.") {
		@Override
		public void turnOff(Light light) {
			light.setState(OFF);
		}
	}, OFF("Lights are off.") {
		@Override
		public void turnOn(Light light) {
			light.setState(ON);
		}
	};
	private final String message;

	private LightStateAsEnum(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void turnOn(Light light) {
		//template
	}

	@Override
	public void turnOff(Light light) {
		//template
	}

}
