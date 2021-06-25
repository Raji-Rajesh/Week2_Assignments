package week2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {
	public static void main(String[] args) {

		// Set up browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[4]")).click();

		// Or
		// driver.findElement(By.xpath("(//img)[2]")).click();
		// driver.findElement(By.xpath("(//img)[5]")).click();

		// Click me using Keyboard or Mouse--->This will be handled later upcoming
		// classes
		// WebElement findElement = driver.findElement(By.xpath("(//img)[4]"));
		// findElement.sendKeys(Keys.ENTER);

		// Am I Broken Image
		String brokenImageUrl = driver.findElement(By.xpath("(//img)[3]")).getAttribute("src");
		driver.get(brokenImageUrl);
		String title = driver.getTitle();
		if (title.contains("404")) {
			System.out.println("Image is Broken");
		}

		driver.close();

	}
}
