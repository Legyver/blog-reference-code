package com.legyver.blog.powerenum;

public class Light {
	private LightState state;

	public Light(LightState defaultState) {
		this.state = defaultState;
	}

	public LightState getState() {
		return state;
	}

	public void setState(LightState state) {
		this.state = state;
	}

	public void turnOn() {
		state.turnOn(this);
	}

	public void turnOff() {
		state.turnOff(this);
	}

	public String getStatusUpdate() {
		return state.getMessage();
	}

}
