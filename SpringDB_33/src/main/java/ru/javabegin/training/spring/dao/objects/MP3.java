package ru.javabegin.training.spring.dao.objects;

public class MP3 {
	
	 int id ;
	
	public  int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	private String name;
	private String author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
