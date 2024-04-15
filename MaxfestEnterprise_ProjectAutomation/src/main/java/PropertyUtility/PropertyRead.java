package PropertyUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyRead 
{
	 public Properties readPropertiesFile(String fileName) throws IOException 
	 {
		 String path = System.getProperty("user.dir") + "\\src\\main\\resources\\propertyFiles\\" +fileName ;
		 //System.out.println(path);
	      FileInputStream fis = null;
	      Properties prop = null;
	      try 
	      {
	         fis = new FileInputStream(path);
	         prop = new Properties();
	         prop.load(fis);
	      } 
	      catch(FileNotFoundException fnfe) 
	      {
	         fnfe.printStackTrace();
	      } 
	      catch(IOException ioe) 
	      {
	         ioe.printStackTrace();
	      } 
	      finally 
	      {
	         fis.close();
	      }
	      return prop;
	   }
}

