package week2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithRadioButtons {
	public static void main(String[] args) {
		
		//To set up browser and initialize the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//1.To select the value of "Are you enjoying the class?"
		driver.findElement(By.xpath("(//div[@id='first']//input)[2]")).click();
		boolean selected = driver.findElement(By.xpath("(//div[@id='first']//input)[2]")).isSelected();
		if(selected) {
			System.out.println("The value is selected successfully");
		}
		else
		{
			System.out.println("The value is not selected successfully");
		}
		
		
		//2.To find default selected value
		for(int i=1;i<3;i++) {
			boolean defaultSelectedValue = driver.findElement(By.xpath("(//input[@name='news'])["+i+"]")).isSelected();
			if(defaultSelectedValue) {
				String val = driver.findElement(By.xpath("(//input[@name='news'])["+i+"]")).getAttribute("value");
				if(val.equals("0")) {
					System.out.println("The default selected value is Unchecked");
				}
				else
				{
					System.out.println("The default selected value is Checked");
				}
		}
		}
		
		//Select your age group (Only if choice wasn't selected)
		int age=54;
		if(age<=20) {
			driver.findElement(By.xpath("(//input[@name='age'])[1]")).click();
			System.out.println("Age is between 1 - 20 years");
		}
		else if(age>20 && age<40) {
			driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();
			System.out.println("Age is between 21 - 40 years");
		}
		else
		{
			driver.findElement(By.xpath("(//input[@name='age'])[3]")).click();
			System.out.println("Age is above 40 years");
		}
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.close();
		
	}

}

