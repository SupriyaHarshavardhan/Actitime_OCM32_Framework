package practiceddt;

import java.util.Date;

import org.testng.annotations.Test;

public class Sample1 {
	
	@Test
	public void main()
	{
		String currentDate=new Date().toString();
		System.out.println(currentDate);
	}

}
