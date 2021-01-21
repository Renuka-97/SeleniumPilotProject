package test;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelExecute {

	ChromeDriver driver;

	@Test(dataProvider = "testdata")
	public void DemoProject(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Renuka Zade\\eclipse-workspace\\MyProject\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/");

		//click to log in
		driver.findElement(By.id("w3loginbtn")).click();

		//Entering username
		driver.findElement(By.name("n")).sendKeys(username);

		//Entering password
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[4]/input")).sendKeys(password);

		//Click login button
		driver.findElement(By.id("login_submit_button")).click();

		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="testdata")
	public Object[][] TestDataExcel(){

		NewDemoRead excel = new NewDemoRead("C:\\Users\\Renuka Zade\\eclipse-workspace\\MyProject\\excel\\data1.xlsx");
		int rows = excel.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for(int i=0; i<rows; i++)
		{ 
			data[i][0] = excel.getData(0, i, 0);
			data[i][1] = excel.getData(0, i, 1);
		}
		return data;
	}

}
