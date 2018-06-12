package com.legyver.blog.powerenum;

public interface LightStateAsInterface {
	LightsInterfaceImpl ON = new LightsInterfaceImpl("Lights are on.") {
		@Override
		public void turnOff(Light light) {
			light.setState(OFF);
		}
	};
	LightsInterfaceImpl OFF = new LightsInterfaceImpl("Lights are off.") {
		@Override
		public void turnOn(Light light) {
			light.setState(ON);
		}
	};

	public class LightsInterfaceImpl implements LightState {

		private final String message;

		private LightsInterfaceImpl(String message) {
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

}
