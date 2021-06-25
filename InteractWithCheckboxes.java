package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCheckboxes {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// 1.To select the language that we know
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[2]")).click();

		// 2.To confirm Selenium is checked
		boolean chkSelenium = driver.findElement(By.xpath("//div[@class='example'][2]//input")).isSelected();
		if (chkSelenium) {
			System.out.println("Selenium checkbox is checked");
		}

		// 3.Deselect only checked
		for (int i = 1; i < 3; i++) {

			boolean deselect = driver.findElement(By.xpath("(//div[@class='example'][3]//input)[" + i + "]"))
					.isSelected();
			if (deselect) {
				driver.findElement(By.xpath("(//div[@class='example'][3]//input)[" + i + "]")).click();

				// To verify whether the checkbox is unchecked
				boolean verifyUncheck = driver.findElement(By.xpath("(//div[@class='example'][3]//input)[" + i + "]"))
						.isSelected();
				if (!verifyUncheck) {
					System.out.println("Checked are deselected successfully");
				}
			}
		}

		// 4.To select all the check boxes below
		
		for (int j = 1; j < 6; j++) {
			driver.findElement(By.xpath("((//div[@class='example'][4])//input)[" + j + "]")).click();
			boolean verifyAllChecks = driver.findElement(By.xpath("((//div[@class='example'][4])//input)[" + j + "]")).isSelected();
			if (verifyAllChecks) {
				System.out.println("Option " + j + " is checked successfully");
			}
		}
		driver.close();
	}
}