package beans;

import java.util.Date;

public class CameraMod implements Sensor{

	private String name;
	private boolean CameraOn;
	private Date ActiveRecordTime;
	
	public CameraMod() {
		this.name = "";
		this.CameraOn = false;
		this.ActiveRecordTime = null;
	}
	
	public CameraMod(String name, boolean CO, Date detectedAt) {
		this.name = name;
		this.CameraOn = CO;
		this.ActiveRecordTime = detectedAt;
	}
	
	public void SensorAdd(String name) {
		this.name = name;
		
		System.out.println("User has added camera named: " + name);
	}
}
