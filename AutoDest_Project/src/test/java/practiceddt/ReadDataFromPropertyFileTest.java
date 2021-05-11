package practiceddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFileTest {
	@Test	
	public void readDataTest() throws IOException {
		FileInputStream fis=new FileInputStream("./datas/commondata.property");
		Properties pObj= new Properties();
		pObj.load(fis);
		String URL = pObj.getProperty("url");
		String  BROWSE= pObj.getProperty("browser");
		String  USERNAME= pObj.getProperty("username");
		String TIMEOUT= pObj.getProperty("timeout");
		
		System.out.println(URL);
		System.out.println(BROWSE);
		System.out.println(USERNAME);
		System.out.println(TIMEOUT);
		
	}


}
