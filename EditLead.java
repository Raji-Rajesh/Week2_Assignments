package week2.assignments2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
		
		//to set up the browser and url
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Log in to Url
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Welcome Page
		driver.findElement(By.xpath("//img[@src='/opentaps_images/integratingweb/crm.png']")).click();
		Thread.sleep(2000);
		
		//Home page
		driver.findElement(By.linkText("Leads")).click();
		
		//Find Lead page
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Gopi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		//To click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		
		//To verify whether the action landed on correct page
		String viewLead = driver.getTitle();
		
		if(viewLead.contains("View Lead")) {
			System.out.println("View Lead page is loaded successfully");
		}
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(updatedCompanyName.contains("Test Leaf")) {
			System.out.println("The company name is updated successfully");
		}
		else
		{
			System.out.println("The company name is not updated successfully");
		}
		driver.close();
		
	}

}
