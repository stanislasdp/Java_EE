package firstHibernateProject;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
//single table means that class and its implementations are stored in the single table.
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
// discriminator column is used to distinguish between to which class record belongs and it contains class name
@DiscriminatorColumn (name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Vehicle 
{
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	

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
	
	
	public void setVehicleName(String vehicleName) 
	{
		this.vehicleName = vehicleName;
	}
	
	

}
