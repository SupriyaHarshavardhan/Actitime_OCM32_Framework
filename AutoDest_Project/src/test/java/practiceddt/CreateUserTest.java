package practiceddt;

import org.testng.annotations.Test;

public class CreateUserTest {
	@Test
	public void userTest() {
		
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String BROWSER = System.getProperty("browser");
		String TIMEOUT = System.getProperty("timeout");
		
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(BROWSER);
		System.out.println(TIMEOUT);
	}
}



