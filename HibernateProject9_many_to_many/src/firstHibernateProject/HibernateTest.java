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
		 
		  
		  Vehicle vehicle = new Vehicle();
		  vehicle.setVehicleName("Car");
		  
		  
		  Vehicle vehicle2 = new Vehicle();
		  vehicle2.setVehicleName("Jeep");
		
		 
		  UserDetails user = new UserDetails();
			/*user.setUserId(1);*/
			user.setUserName("first name");
			user.setDescription("first user description");
			user.getVehicles().add(vehicle);
			user.getVehicles().add(vehicle2);
			vehicle.getUser().add(user);
			vehicle2.getUser().add(user);
			
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.save(vehicle);
			session.save(vehicle2);
			session.getTransaction().commit();
			session.close();
			
			Session sessionGet = sessionFactory.openSession();
			// second argument means that object with primary key "1" reference will be retreived
			UserDetails userRet = (UserDetails)sessionGet.get(UserDetails.class, 1);
			//when get user addresses lazy initalization is used

			
			
				
	  }
}
