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
		  Address addr = new Address();
		  addr.setStreet("Street Name");
		  addr.setCity("city Name");
		 
		  
		  
		  UserDetails user = new UserDetails();
			/*user.setUserId(1);*/
			user.setUserName("first name");
			user.setJoinedDate(new Date());
			user.setAddress(addr);
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
