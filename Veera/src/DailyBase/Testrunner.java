package DailyBase;

import java.awt.AWTException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testrunner {
	
	public static void main(String[] args) throws AWTException, Throwable {

		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/Users/Vasu/chromedriver.exe");
		  
		WebDriver	driver=new ChromeDriver();
	
		 
		   
		   /*Dimension d=new Dimension(400, 400);
		   driver.manage().window().setSize(d);*/
		   driver.manage().window().maximize();
		   
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  String W1=driver.getWindowHandle();
		  System.out.println(W1);
		 // driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");;
		  driver.get("https://www.naukri.com/");
		 Set< String> W2=driver.getWindowHandles();
		  System.out.println(W2);
		  System.out.println(W2.size());
		  for(String W:W2) {
			 // System.out.println(W);
			  driver.switchTo().window(W);
			  String title=driver.getTitle();
			  System.out.println(title);
			  
			  
			 // Thread.sleep(3000);
			  
			  //driver.quit();
		  }
	}

}
