package DAL;

import java.util.ArrayList;

import model.Person;

public interface PersonDAO 
{

	void create(Person person);
	ArrayList<Person> read();
	void update(Person person);
	void delete(Person person);
}
