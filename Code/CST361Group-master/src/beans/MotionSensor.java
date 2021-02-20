package beans;

import java.util.Date;

public class MotionSensor implements Sensor{
	
	private String name;
	private boolean motionDetected;
	private Date detectedAt;
	
	public MotionSensor() {
		this.name = "";
		this.motionDetected = false;
		this.detectedAt = null;
	}
	
	public MotionSensor(String name, boolean motionDetected, Date detectedAt) {
		this.name = name;
		this.motionDetected = motionDetected;
		this.detectedAt = detectedAt;
	}
	
	public void SensorAdd(String name) {
		this.name = name;
		
		System.out.println("Motion Sensor has now been added to user sensors named: " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMotionDetected() {
		return motionDetected;
	}

	public void setMotionDetected(boolean motionDetected) {
		this.motionDetected = motionDetected;
	}

	public Date getDetectedAt() {
		return detectedAt;
	}

	public void setDetectedAt(Date detectedAt) {
		this.detectedAt = detectedAt;
	}

}
