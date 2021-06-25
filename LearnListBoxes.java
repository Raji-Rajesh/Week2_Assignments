package week2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListBoxes {
	public static void main(String[] args) {

		// To setup web driver manager and initialize the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// 1. Select Training program using index
		WebElement usingIndex = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select firstDropdown = new Select(usingIndex);
		firstDropdown.selectByIndex(2);

		// 2.Select Training program using Text
		WebElement usingText = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select secondDropdown = new Select(usingText);
		secondDropdown.selectByVisibleText("UFT/QTP");

		// 3.Select Training program using value
		WebElement usingValue = driver.findElement(By.id("dropdown3"));
		Select thirdDropdown = new Select(usingValue);
		thirdDropdown.selectByValue("4");

		/*
		 * 5.Use sendKeys to select the drop down value		
		 * few Xpaths to locate the given drop down
		 * 
		 * "//div[@id='contentblock']//section//div[5]/select"-> Grandparent to child
		 * "//section[@class='innerblock']/div[5]/select"-->parent to child
		 * "//select[@class='dropdown']/following::select[1]"--->elder cousin to younger cousin
		 * 
		 * 
		 * 
		 */
		WebElement usingSendkeys = driver.findElement(By.xpath("//section[@class='innerblock']/div[5]/select"));
		usingSendkeys.sendKeys("Selenium");
		
		//6.Select multiple values for a drop down
		WebElement multipleValues = driver.findElement(By.xpath("//section[@class='innerblock']/div[6]/select"));
		Select obj=new Select(multipleValues);
		obj.selectByIndex(1);
		obj.selectByValue("3");
		obj.selectByVisibleText("Loadrunner");
		
		driver.close();
		
	   
		
	

	}

}
