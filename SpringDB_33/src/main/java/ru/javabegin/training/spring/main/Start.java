package ru.javabegin.training.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.impls.H2DAO;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 mp3 = new MP3();
		mp3.setId(1);
		//mp3.setName("forlist");
		//mp3.setAuthor("Song author5");*/
		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		H2DAO H2DAO = (H2DAO) context.getBean("H2DAO");
		//H2DAO.insert(mp3);
		/*System.out.println(H2DAO.getMP3ByID(1).getName());*/
		
		H2DAO.delete(mp3);
		/*List<MP3> list = H2DAO.getMP3ListByName("forlist");
		
		for (MP3 mp3 : list) 
		{
			System.out.println(mp3.getId()+" " + mp3.getName()+ " " + mp3.getAuthor());
		}*/

	}

}
