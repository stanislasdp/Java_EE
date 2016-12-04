package firstHibernateProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

	//annotation used for  collection
	@ElementCollection
	//for overriding column names annotation attributes override is used
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="USER_ID"))
	//generator is how to primary key to be generated (hilo is common genarator type)
	@GenericGenerator(name ="hilo-gen", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long")) 
	private Collection<Address> listofAddresses = new ArrayList();
	
	public Collection<Address> getListofAddresses() 
	{
		return listofAddresses;
	}
	public void setListofAddresses(Collection<Address> listofAddresses) 
	{
		this.listofAddresses = listofAddresses;
	}
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
