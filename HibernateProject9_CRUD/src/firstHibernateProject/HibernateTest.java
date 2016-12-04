package firstHibernateProject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;
import org.omg.CORBA.VersionSpecHelper;

public class HibernateTest 
{
	private static Logger logger = Logger.getLogger(HibernateTest.class);
	
	

	  public static void main(String[] args)
	  {
	
		
			
				
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 UserDetails user = new UserDetails();
			 user.setUserName("First User");
			session.save(user);
			
			session.getTransaction().commit();
			session.close();
			
	

			
			
				
	  }
}
