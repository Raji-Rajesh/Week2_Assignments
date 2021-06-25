package week2.assignments4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusSearch {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	//	driver.findElement(By.id("src")).sendKeys("Chennai",Keys.TAB);
		
		WebElement webSource = driver.findElement(By.id("src"));
		webSource.sendKeys("Chennai");
		Thread.sleep(2000);
		webSource.sendKeys(Keys.TAB);
		
	//	driver.findElement(By.xpath("(//section[@id='search']//input)")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
	//	driver.findElement(By.id("dest")).sendKeys("Bangalore",Keys.TAB);
		WebElement webDest= driver.findElement(By.id("dest"));
		webDest.sendKeys("Bangalore");
		Thread.sleep(2000);
		webDest.sendKeys(Keys.TAB);
		
	//Picking date
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[@class='wd day']")).click();
		Thread.sleep(2000);
		
	//Search buses
		driver.findElement(By.id("search_btn")).click();
		
		Thread.sleep(2000);
		
	//Handling window pop up for covid 19 instructions
		driver.findElement(By.className("close")).click();
		
	//Total no of buses found on selected date
		String text = driver.findElement(By.xpath("//span[text()='Buses']")).getText();
		String noOfBuses = text.replaceAll("\\D", "");
		System.out.println("Total no of buses found: "+noOfBuses);
		
	//Select Seater buses only
		driver.findElement(By.xpath("//label[@for='bt_SEATER']")).click();
		String text1 = driver.findElement(By.xpath("//span[text()='Buses']")).getText();		
		String noOfSeaterBuses = text1.replaceAll("\\D", "");
		System.out.println("No of seater buses found: "+noOfSeaterBuses);
		
		Thread.sleep(2000);
		
	//Select AC buses also
		driver.findElement(By.xpath("//label[@for='bt_AC']")).click();		
		String text2 = driver.findElement(By.xpath("//span[text()='Buses']")).getText();		
		String noOfACBuses = text2.replaceAll("\\D", "");
		System.out.println("No of AC and Seater buses found: "+noOfACBuses);
		
	//Closing the browser
		driver.close();
		
	}

}
