package ru.javabegin.training.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.Author;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) 
	{
		Author author1 = new Author();
		author1.setName("Author 1 name");
		author1.setId(1);
		Author author2 = new Author();
		author2.setName("Author 2 name");
		author2.setId(2);
		MP3 mp3_1 = new MP3();
		mp3_1.setName("first song name");
		mp3_1.setAuthor(author1);

		MP3 mp3_2 = new MP3();
		mp3_2.setName("second song name");
		mp3_2.setAuthor(author2);

		List<MP3> list = new ArrayList<>();

		list.add(mp3_1);
		list.add(mp3_2);

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MP3Dao H2DAO = (MP3Dao) context.getBean("H2DAO");
		H2DAO.insert(mp3_1);
		

		//System.out.println(sqLiteDAO.insertList(list));
		
		
	}
}
