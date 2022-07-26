package Mobile;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllMobiles {
	@Test(dataProvider="all")
	public void allmobile(String firstname, String lastname, String email, String password, String mobile, String add1, String add2, String city, String zip, String count) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\srihari.s\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://mobileworld.azurewebsites.net/");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("All Mobiles")).click();
	driver.findElement(By.xpath("//tbody[@id='myTable']/tr[9]/td[5]/a")).click();
	Thread.sleep(2000);
	//window handeling
			Set<String> window=driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			String mob1=it.next();
			String mob2=it.next(); 
			driver.switchTo().window(mob2);
			//first name and last name
			List<WebElement> li =driver.findElements(By.id("inputFirstName"));
			li.get(0).sendKeys(firstname);
			li.get(1).sendKeys(lastname);
			//email, password , gender and mobile number
			driver.findElement(By.id("inputEmail")).sendKeys(email);
			driver.findElement(By.id("inputPassword")).sendKeys(password);
			driver.findElement(By.id("flexRadioDefault1")).click();
			driver.findElement(By.xpath("//input[@min='0']")).sendKeys(mobile);
			//address 
			driver.findElement(By.id(" address1")).sendKeys(add1);
			driver.findElement(By.id("address2")).sendKeys(add2);
			driver.findElement(By.id("inputCity")).sendKeys(city);
			WebElement option=driver.findElement(By.id("inputState"));
			Select dropdown=new Select(option);
			dropdown.selectByIndex(1);
			driver.findElement(By.id("inputZip")).sendKeys(zip);
			//selecting brand and count
			driver.findElement(By.xpath("//input[@rel='samsung']")).click();
			Thread.sleep(1000);
	    	driver.findElement(By.xpath("//input[@rel='apple']")).click();
			WebElement choose=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/fieldset/div/div[3]/div/div[3]/select"));
			Select phone=new Select(choose);
			phone.selectByIndex(2);
			driver.findElement(By.xpath("//input[@placeholder='no of mobiles']")).sendKeys(count);
			//already brought 
			WebElement click=driver.findElement(By.id("bought"));
			Select no=new Select(click);
			no.selectByIndex(1);
			//check box
			List<WebElement> check =driver.findElements(By.id("gridCheck1"));
			check.get(0).click();
			check.get(1).click();
			//order
			driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Close")).click();
			driver.quit();
	}
	@DataProvider(name="all")
	public Object[][] getData()
	{
		//valid
		Object[][] input=new Object[2][10];
		input[0][0]="Srihari";
		input[0][1]="S";
		input[0][2]="Srihari@gmail.com";
		input[0][3]="pqrst";
		input[0][4]="1234567890";
		input[0][5]="10/11";
		input[0][6]="somasundarm first street";
		input[0][7]="chennai";
		input[0][8]="600082";
		input[0][9]="2";
		
		
		//invalid
		input[1][0]="12345678";
		input[1][1]="@";
		input[1][2]="Sriharigmail.com";
		input[1][3]="pqrst";
		input[1][4]="asxdcvbnm";
		input[1][5]="10/11";
		input[1][6]="somasundarm first street";
		input[1][7]="chennai";
		input[1][8]="600082";
		input[1][9]="2";
		return input;
		
	}
}
