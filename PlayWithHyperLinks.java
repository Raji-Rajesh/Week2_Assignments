package week2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperLinks {
	public static void main(String[] args) {
		int i=1;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//1. Go To Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();

		// 2.Find where am supposed to go without clicking me
		String destinationPlace = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("The destination place if you click this link is : " + destinationPlace);

		//3.Interact with same link name
		String link1 = driver.findElement(By.xpath("(//a)[2]")).getAttribute("href");
		String link2=driver.findElement(By.xpath("(//a)[5]")).getAttribute("href");
		if(link1.equals(link2)) {
			System.out.println("The destination page of First and Fourth link is same");
			 driver.findElement(By.xpath("(//a)[2]")).click();
			 driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();
		}
		else
		{
			System.out.println("The destination page of First and Fourth link is not same");
		}
		
		
		//4.How many links are available in this page?
		for(i=1;i<7;i++) {			
		String hrefLink = driver.findElement(By.xpath("(//a)["+ i +"]")).getAttribute("href");
		if(!hrefLink.isEmpty()) {
		//System.out.println("Name of "+i+" link is: "+hrefLink);
			continue;
		}				
		}
		System.out.println("Total Number of links available are : "+(i-1));
		
		
		// 5.Verify am I broken.
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String brokenPage = driver.findElement(By.tagName("h1")).getText();
		if (brokenPage.contains("404")) {
			System.out.println("The given link is broken");
		} else {
			System.out.println("The given link is not broken");
		}
		
		//close the browser
		driver.close();
		

	}

}
