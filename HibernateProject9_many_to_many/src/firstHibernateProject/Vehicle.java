package firstHibernateProject;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Vehicle 
{
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany (mappedBy="vehicles")
	private Collection<UserDetails> user = new ArrayList<>();
	
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
	
	
	public Collection<UserDetails> getUser() {
		return user;
	}
	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
	public void setVehicleName(String vehicleName) 
	{
		this.vehicleName = vehicleName;
	}
	
	

}
