package DailyBase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Worddown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Vasu/chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		
		driver.get("https:www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement Search=driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input"));
		Search.sendKeys("vasu");
		List<WebElement> ele=driver.findElements(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[2]/div[2]//ul//li"));
		List names=new ArrayList();
		for (int i = 1; i <10; i++) {
			//names.add(ele.get(i).getText());
			Search.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		if(i==5) {
			Search.sendKeys(Keys.chord(Keys.ENTER));
		
		
		System.err.println("+++++++++++"+names);
		
	/*	 if(names.contains("vasudev")) {
			 
			
		}*/
		}
		}
	}

}
