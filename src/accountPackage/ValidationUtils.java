package accountPackage;

public class ValidationUtils {
	
	
	
	
	
	public static void validateId(int id) throws InvalidAccountException
	{
		if(id < 0)
		{
			throw new InvalidAccountException("\nAccount ID cannot be Negative");
		} 
		else if(id>=1000)
		{
			throw new InvalidAccountException("\nAccount ID cannot be Exceeded");
		}
		else if(id==0)
		{
			throw new InvalidAccountException("\nAccount ID cannot be zero.");
		}
		else
		{
			System.out.println(id);
		}
		
	}
	
	public static void validateName(String name) throws InvalidAccountException
	{
		String regex = "^A-Za-z{2,15}$ ";
		if(name.length() < 2)
		{
			throw new InvalidAccountException("\nName Must Be More Than Two Characters");
		}
		else if(name.length()>=20)
		{
			throw new InvalidAccountException("\nName Must not be exceeded");
			
		}
		else if(name == regex)
		{
			
			System.out.println(name);
		}
	}
	
	public static void validateType(String type) throws InvalidAccountException
	{
		
		if(type.length()>10)
		{
			throw new InvalidAccountException("Invalid type");
		}
		
		else
		{
			System.out.println(type);
		}
	}
	
}