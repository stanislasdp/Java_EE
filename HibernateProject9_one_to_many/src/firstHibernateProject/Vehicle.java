package firstHibernateProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Vehicle 
{
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	/*@ManyToOne
	private UserDetails user;*/
	
	public int getVehicleId() 
	{
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) 
	{
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() 
	{
		return vehicleName;
	}
	/*public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}*/
	public void setVehicleName(String vehicleName) 
	{
		this.vehicleName = vehicleName;
	}
	
	

}
