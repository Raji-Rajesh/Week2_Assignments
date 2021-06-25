package week2.assignments3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {

		// to set up the browser and url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Log in to Url
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// Welcome Page
		driver.findElement(By.xpath("//img[@src='/opentaps_images/integratingweb/crm.png']")).click();
		Thread.sleep(2000);

		// Home page
		driver.findElement(By.linkText("Leads")).click();

		// Find Lead page
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Find lead using phone number
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//Capture lead ID of First Resulting lead
		String leadId = driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)")).getText();
		System.out.println("The Lead ID is: "+leadId);
		
		//Click on lead ID of First Resulting lead
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)")).click();
		
		//Click on delete button in view lead page
		driver.findElement(By.linkText("Delete")).click();
		
		//To verify whether the lead id is deleted properly
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String noRecords = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(noRecords.contains("No records")) {
			System.out.println("Verified successfully");
		}
		
		//CLosing the browser
		driver.close();
		

	}
}
