package Mobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginScript {
	@Test(dataProvider="get")
	public void login1(String username, String password) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\srihari.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://mobileworld.azurewebsites.net/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("/html/body/nav/div/button")).click();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[4]/a")).click();
	Thread.sleep(2000);
	
	driver.quit();
	}
	
	@DataProvider(name="get")
	public Object[][] getData()
	{
		//valid
		Object[][] Data=new Object[2][2];
		Data[0][0]="Vikram";
		Data[0][1]="Rolex";
		
		
		//invalid
		Data[1][0]="@#$%^";
		Data[1][1]="#$%^";
		return Data;
	}
}
