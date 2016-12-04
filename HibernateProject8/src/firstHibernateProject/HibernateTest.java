package firstHibernateProject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class HibernateTest 
{
	private static Logger logger = Logger.getLogger(HibernateTest.class);
	
	

	  public static void main(String[] args)
	  {
		  Address address1 = new Address();
		  address1.setStreet("Home Street Name");
		  address1.setCity("Home city Name");
		  address1.setState("Addr 1 state");
		  address1.setPinCode("1234");
		  
		  Address address2 = new Address();
		  address2.setStreet("Home Street Name");
		  address2.setCity("Home city Name");
		  address2.setState("Addr 1 state");
		  address2.setPinCode("1234");
		  
		  
		  UserDetails user = new UserDetails();
			/*user.setUserId(1);*/
			user.setUserName("first name");
			user.setJoinedDate(new Date());
			user.getListofAddresses().add(address1);
			user.getListofAddresses().add(address2);
			user.setDescription("first user description");
			
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			Session sessionGet = sessionFactory.openSession();
			// second argument means that object with primary key "1" reference will be retreived
			UserDetails userRet = (UserDetails)sessionGet.get(UserDetails.class, 1);
			//when get user addresses lazy initalization is used

			System.out.println(user.getListofAddresses().size());
			
			
				
	  }
}
