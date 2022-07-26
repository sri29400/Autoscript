package Mobile;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Support {
	@Test(dataProvider="models")
	public void support(String username,String email,String number,String message) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srihari.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mobileworld.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/nav/div/ul/li[4]/a")).click();
		driver.findElement(By.linkText("Contact Us")).click();
		Set<String> next=driver.getWindowHandles();
		Iterator<String> it=next.iterator();
		String page1=it.next();
		String page2=it.next(); 
		driver.switchTo().window(page2);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(number);
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys(message);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	@DataProvider(name="models")
	public Object[][] getData()
	{
		//positive
		Object[][] phone=new Object[2][4];
		phone[0][0]="Srihari";
		phone[0][1]="Srihari@gmail.com";
		phone[0][2]="12345";
		phone[0][3]="Its not a good deal with people";
		//negative
		phone[1][0]="Srihari";
		phone[1][1]="Sriharigmail.com";
		phone[1][2]="123456";
		phone[1][3]="Its not a good deal with people";
		return phone;
	}

}
