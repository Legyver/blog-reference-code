# blog-reference-code
Reference code blog.legyver.xom

##Power of Enums
So as Java developers, we're constantly told to favor using enums over constants, but why?  And how does this then work?

Basically, by using enums, we can give each type instance its own state, and its own behavior.

```java
public interface LightState {
	String getMessage();
	void turnOn(Light light);
	void turnOff(Light light);
}
```
For example in the above snippet, we declare the behavior of a light.

Implementing this as an enum could be written as
```java
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
```
Note that each state is responsible for transitioning to the next state.  This encapsulates the knowledge of the state within the enum itself.  Its not necessary to implement an interface, I only did it to illustrate the next point.

So how does this actually work?  Well if think of each enum value as its own implementation, its functionally equivalent to a static constant in an interface, where the constant value is an implementation of the LightState interface.

```java
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
```

The following test demonstrates their equivalence.
```java
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
```




