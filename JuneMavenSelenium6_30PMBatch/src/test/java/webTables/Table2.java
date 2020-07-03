package webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Table2 
{
	public static WebDriver driver = null ;
	public static WebDriverWait wait ;

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in/");
		wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'More')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Flights')]")))).click();
				
		//checkIn
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='picker-label target'])[1]")))).click();
		String date = "10-Jul 2020";
		String[] splitter1 = date.split("-");
		String checkInDay = splitter1[0];
		String checkInMonth = splitter1[1];
		Thread.sleep(4000);
		selectDate(checkInDay,checkInMonth);
		
		//checkOut
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[@class='picker-label target'])[2]")))).click();
		String date1 = "15-Jul 2020";
		String[] splitter2 = date1.split("-");
		String checkOutDay = splitter2[0];
		String checkOutMonth = splitter2[1];
		Thread.sleep(4000);
		selectDate(checkOutDay,checkOutMonth);
	}

	public static void selectDate(String day, String year) throws Exception 
	{
		System.out.println("iam in..");
		wait = new WebDriverWait(driver, 30);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rsdc-months']/span/span[1]"));
		for(int i=0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			if(elements.get(i).getText().equals(year))
			{
				List<WebElement> days = driver.findElements(By.xpath("//div[@class='rsdc-months']/span["+ (i+1) +"]/span"));
				for(WebElement d : days)
				{
					if(d.getText().equals(day))
					{
						d.click();
						break;
					}
				}
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'rsdc-next rsdc-nav ui_icon single-chevron-right-circle')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'rsdc-next rsdc-nav ui_icon single-chevron-right-circle')]")))).click();
		
		Thread.sleep(2000);
		selectDate(day, year);
	}

}
