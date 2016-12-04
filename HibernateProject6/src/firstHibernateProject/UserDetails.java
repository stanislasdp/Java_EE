package firstHibernateProject;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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

	//for overriding column names annonation attributes override is used
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pinCode",column=@Column(name="HOME_PIN_CODE"))
	}
			)

	private Address homeAddress;

	@Embedded
	private Address officeAddress;

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


	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
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
