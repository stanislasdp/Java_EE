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
		  UserDetails user = new UserDetails();
			/*user.setUserId(1);*/
			user.setUserName("first name");
			user.setAddress("First User Address");
			user.setJoinedDate(new Date());
			user.setDescription("first user description");
			
			 UserDetails user2 = new UserDetails();
				/*user.setUserId(1);*/
				user2.setUserName("second name");
				user2.setAddress("Second User Address");
				user2.setJoinedDate(new Date());
				user2.setDescription("second user description");
			
			
			
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.save(user2);
			session.getTransaction().commit();
			/*session.flush();*/
			session.close();
			 
		
		/*	Session session2 = sessionFactory.openSession();
			UserDetails user2 = (UserDetails)session2.get(UserDetails.class, 1);
		    user2.setUserName(user.getUserName()+"retrieved");
		    session2.beginTransaction();
		    session2.save(user2);
		    session2.getTransaction().commit();
		    session2.flush();
		    session2.close();*/
			
			
			
	  }
}
