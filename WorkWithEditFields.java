package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class WorkWithEditFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Email address
		driver.findElement(By.id("email")).sendKeys("mail@mail.com");

		// Append a text and press keyboard tab
		String str = driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value");
		if (!str.equals(" ")) {
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("text");
		}
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.TAB);

		// Get default text entered
		String str1 = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println(str1);

		// Clear the text
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();

		// Confirm that edit field is disabled
		boolean editable = driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled();
		if (editable) {
			System.out.println("The edit field is enabled");
		} else {
			System.out.println("The edit field is disabled");
		}

		driver.close();

	}

}
