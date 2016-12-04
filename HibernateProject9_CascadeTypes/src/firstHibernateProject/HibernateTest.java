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
		 
		  Vehicle vehicle = new Vehicle();
		  vehicle.setVehicleName("car");
		
		  UserDetails user = new UserDetails();
			/*user.setUserId(1);*/
			user.setUserName("first name");
			user.setDescription("first user description");
			/*user.getVehicles().add(vehicle);
			user.getVehicles().add(vehicle2);*/
			
			
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(vehicle);
			session.getTransaction().commit();
			session.close();
			
			Session sessionGet = sessionFactory.openSession();
			// second argument means that object with primary key "1" reference will be retreived
			UserDetails userRet = (UserDetails)sessionGet.get(UserDetails.class, 1);
			//when get user addresses lazy initalization is used

			
			
				
	  }
}
