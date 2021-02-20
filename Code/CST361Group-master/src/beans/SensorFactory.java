package beans;

public class SensorFactory {

	public Sensor getSensorType(String sensorType) {
		if(sensorType == null) {
			return null;
		}
		if(sensorType == "MotionSensor") {
			return new MotionSensor();
		}
		if(sensorType == "CameraMod") {
			return new CameraMod();
		}
		return null;
	}
	
}
