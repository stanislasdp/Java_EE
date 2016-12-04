package firstHibernateProject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bike")
public class TwoWheeler extends Vehicle 
{

	private String SteeringHandle;

	public String getSteeringHandle() 
	{
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) 
	{
		SteeringHandle = steeringHandle;
	}
	
}
