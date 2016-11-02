import org.springframework.stereotype.Component;

@Component
public class Volunteer implements Thinker {

	private String thoughts;
	
	@Override
	public void thinkSomething(String thoughts) 
	{
		this.thoughts = thoughts;
		
	}

	public String getThoughts() 
	{
		return thoughts;
	}

}
