package ru.javabegin.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.impls.H2DAO;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 mp3 = new MP3();
		mp3.setId(3);
		mp3.setName("Song name1");
		mp3.setAuthor("Song author1");

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		H2DAO H2DAO = (H2DAO) context.getBean("H2DAO");
		H2DAO.insert(mp3);

	}

}
