package ru.javabegin.training.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 mp3_9 = new MP3();
		mp3_9.setId(9);
		mp3_9.setName("9 updated Song name");
		mp3_9.setAuthor(" 9 updated Song author");

		MP3 mp3_10 = new MP3();
		mp3_10.setName("10 updated Song name2");
		mp3_10.setAuthor("Song 10 updated author2");

		List<MP3> list = new ArrayList<>();

		list.add(mp3_9);
		list.add(mp3_10);

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MP3Dao H2DAO = (MP3Dao) context.getBean("H2DAO");
		H2DAO.insertList(list);
		

		//System.out.println(sqLiteDAO.insertList(list));
		
		
	}
}
