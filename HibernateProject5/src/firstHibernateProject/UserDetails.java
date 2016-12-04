package firstHibernateProject;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="USER_DETAILS")
public class UserDetails 
{

	@Id
	@GeneratedValue
	private int userId;
	
	private String userName;
	
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	
	@Embedded
	private Address Address;
	private String Description;
	
	
	public String getDescription() 
	{
		return Description;
	}
	public void setDescription(String description) 
	{
		Description = description;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
