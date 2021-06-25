package week2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[2]")).click();
		
		//Find position of button (x,y)
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Find the position of button"+location);
		
		//Find button color
		String col = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("background color is"+col);
		
		//Find the height and width
		int height = driver.findElement(By.id("size")).getSize().getHeight();
		System.out.println("Height of the button is: "+height);
		int width = driver.findElement(By.id("size")).getSize().getWidth();
		System.out.println("Width of the button is: "+width);
		
		driver.close();
	}

}
