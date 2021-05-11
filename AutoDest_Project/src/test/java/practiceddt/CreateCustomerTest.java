package practiceddt;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {
	
		@Test	
		public void ReadTheDataFromXMLFile(XmlTest xml) {
			Object URL = xml.getParameter("url");		
			Object BROWSER = xml.getParameter("browser");
			Object USERNAME = xml.getParameter("username");
			Object TIMEOUT = xml.getParameter("timeout");
			System.out.println(URL);
			System.out.println(BROWSER);
			System.out.println(USERNAME);
			System.out.println(TIMEOUT);		
		}
	}



