package Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUp {
	@Test(dataProvider="Drugs")
	public void SignUp1(String firstname, String lastname, String email, String password,String date, String number, String bio) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\srihari.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://mobileworld.azurewebsites.net/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("/html/body/nav/div/button")).click();
	driver.findElement(By.linkText("Sign up")).click();
	driver.findElement(By.id("myName")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(email);
	driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
	driver.findElement(By.cssSelector("input[type='date']")).sendKeys(date);
	driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[3]/input")).click();
	driver.findElement(By.cssSelector("input[placeholder='91XXXXXXXXXX']")).sendKeys(number);
	driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']")).sendKeys(bio);
	driver.findElement(By.xpath("//button[@class='btn btn-info form-control']")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//button[.='Sign In']")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	
	driver.quit();
	
	}
	@DataProvider(name="Drugs")
	public Object[][] getData()
	{
		Object[][] data=new Object[2][7];
		data[0][0]="Sri";
		data[0][1]="Hari";
		data[0][2]="hari@gmail.com";
		data[0][3]="pass@1234";
		data[0][4]="13/07/2022";
		data[0][5]="1234567890";
		data[0][6]="Proud Tester";
		
		//invalid
		data[1][0]="@#$";
		data[1][1]="2345";
		data[1][2]="harigmail.com";
		data[1][3]="@#$%";
		data[1][4]="!@#$%^&";
		data[1][5]="sdfghj";
		data[1][6]="Proud Tester";
	
		return data;
	}

}
