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
		  address2.setStreet("Home Street Name 2" );
		  address2.setCity("Home city Name 2");
		  address2.setState("Addr 2 state");
		  address2.setPinCode("1254");
		  
		  


		  
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
				
	  }
}
