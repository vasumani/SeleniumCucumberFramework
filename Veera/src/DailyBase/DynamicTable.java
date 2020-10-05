package DailyBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Vasu/chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.toolsqa.com/automation-practice-table/");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		////*[@id="content"]/table/tbody/tr[2]/td[6]
		////*[@id="example"]/tbody/tr[7]/td[1]
		Thread.sleep(20000);
		String before_xpath="//*[@id='example']/tbody/tr[";
		String after_xpath="]/td[1]";
		
	
		
		
		for (int i = 1; i <=10 ; i++) {
			String table_data=driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(table_data);
			
			if(table_data.contains("Bruno Nash")) {//i=10
				driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+i+"]/td[1]")).click();
		
			}
		}

		
	}

}
