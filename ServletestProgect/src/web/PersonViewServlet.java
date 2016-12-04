package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAL.PersonDAO;
import DAL.PersonDAO_H2;
import model.Person;

/**
 * Servlet implementation class PersonViewServlet
 */
@WebServlet("/PersonViewServlet")
public class PersonViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDAO persons;
	public PersonViewServlet() 
	{
		super();
		persons = new PersonDAO_H2();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		int personID = 0;
		if (!request.getParameter("id").isEmpty())
		{
			personID = Integer.parseInt(request.getParameter("id"));
		}

		String personFName = request.getParameter("fname");
		String personLName = request.getParameter("lname");

		int personAge = 0;
		if (!request.getParameter("id").isEmpty())
		{
			personAge = Integer.parseInt(request.getParameter("age"));
		}

		Person person = new Person(personID, personFName, personLName, personAge);
		//PrintWriter printWriter = response.getWriter();
		/*printWriter.write(personID+" " + personFName+ " " + personLName + " " + personAge);*/
		processButtonAction(request, response, person);
	}


	public void processButtonAction(ServletRequest servletRequest,ServletResponse servletResponse, Person person) throws ServletException, IOException
	{
		String buttonClicked = servletRequest.getParameter("button_clicked");
		System.out.println(buttonClicked);

		switch (buttonClicked)
		{
		case "Create":
			create(person);
			break;
		case "Read":
			read(person, servletRequest,servletResponse);
			break;
		case "Update":
			break;
		case "Delete":
			break;
		default:
		}
	}

	public void create (Person person)
	{
		persons.create(person);
	}
	
	public void read (Person person, ServletRequest servletRequest, ServletResponse servletResponse) throws IOException,ServletException
	{
		List<Person> list = persons.read();
		servletRequest.setAttribute("listPersons", list);
		RequestDispatcher view = servletRequest.getRequestDispatcher("result.jsp");
		view.forward(servletRequest, servletResponse);
	}
}
