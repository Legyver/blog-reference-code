package com.legyver.blog.powerenum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PowersEnumTest {

	@Test
	public void enumState() {
		Light light = new Light(LightStateAsEnum.OFF);
		testLightsMessage(light);
	}

	@Test
	public void interfaceState() {
		Light light = new Light(LightStateAsInterface.OFF);
		testLightsMessage(light);
	}

	private void testLightsMessage(Light light) {
		light.turnOn();
		assertThat(light.getStatusUpdate(), is("Lights are on."));

		light.turnOn();//turning lights ON that are already ON should not turn them OFF
		assertThat(light.getStatusUpdate(), is("Lights are on."));

		light.turnOff();
		assertThat(light.getStatusUpdate(), is("Lights are off."));

		light.turnOff();//turning lights OFF that are already OFF should not turn them ON
		assertThat(light.getStatusUpdate(), is("Lights are off."));
	}


}
