package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Person;

public class PersonDAO_H2 implements PersonDAO
{
	@Override
	public void create(Person p)
	{
		try 
		{
			Connection Con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			PreparedStatement st = Con.prepareStatement("INSERT INTO Person VALUES(?,?,?,?)");
			st.setInt(1,p.getId());
			st.setString(2, p.getFirstName());
			st.setString(3, p.getLastName());
			st.setInt(4, p.getAge());
			st.executeUpdate();
			Con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> pp = new ArrayList<Person>();

		try 
		{
			Connection Con = DriverManager.getConnection("jdbc:h2:~/test","sa","");

			Statement st = Con.createStatement();
			ResultSet rs = st.executeQuery("select * from PERSON");

			while (rs.next()) 
			{
				pp.add(new Person(rs.getInt("id"), rs.getString("fname"),rs.getString("lname"),rs.getInt("age")));
			}
			Con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		try 
		{
			Connection Con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			PreparedStatement st = Con.prepareStatement("UPDATE Person SET fname = ?, lname = ?, age = ? WHERE id = ?");

			st.setString(1, p.getFirstName());
			st.setString(2, p.getLastName());
			st.setInt(3, p.getAge());
			st.setInt(4, p.getId());
			st.executeUpdate();

			Con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		try 
		{
			Connection Con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			PreparedStatement st = Con.prepareStatement("DELETE FROM Person WHERE id = ?");

			st.setInt(1, p.getId());
			st.executeUpdate();

			Con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
