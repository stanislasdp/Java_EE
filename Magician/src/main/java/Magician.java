import org.springframework.stereotype.Component;

@Component
public class Magician implements MindReader {

	private String thoughts;
	
	@Override
	public void interceptThoughts(String thoughts) 
	{
		System.out.println("Intercepting volunteer thoughts");
		this.thoughts = thoughts;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getThoughts() 
	{
		// TODO Auto-generated method stub
		return  thoughts;
		
	}

}
