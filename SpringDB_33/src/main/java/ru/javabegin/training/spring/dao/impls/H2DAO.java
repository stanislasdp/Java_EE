package ru.javabegin.training.spring.dao.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.MP3;

@Component("H2DAO")
public class H2DAO implements MP3Dao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(MP3 mp3) {
		String sql = "insert into MP3 (id, name, author) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {mp3.getId(), mp3.getName(), mp3.getAuthor() });
	}

	public void insertWithJDBC(MP3 mp3) 
	{

	
		Connection conn = null;

		try {
			
			conn = DriverManager.getConnection("jdbc:h2:~/test","sa","");

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into mp3 (id,name, author) VALUES (?,?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mp3.getId()+"");
			ps.setString(2, mp3.getName());
			ps.setString(3, mp3.getAuthor());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void delete(MP3 mp3) {
		// TODO Auto-generated method stub

	}

	@Override
	public MP3 getMP3ByID(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MP3> getMP3ListByName(String name) 
	{
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MP3> getMP3ListByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
