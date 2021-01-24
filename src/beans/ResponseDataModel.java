package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel extends ResponseModel{
	
	private MotionSensor data;
	
	public ResponseDataModel() {
		
	}
	
	public ResponseDataModel(int status, String message, MotionSensor data) {
		super(status, message);
		this.data = data;
		// TODO Auto-generated constructor stub
	}

	public MotionSensor getData() {
		return data;
	}

	public void setData(MotionSensor data) {
		this.data = data;
	}

	
	
	

}
