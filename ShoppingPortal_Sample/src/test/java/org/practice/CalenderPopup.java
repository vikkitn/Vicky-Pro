package org.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yantra.genericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup {

	public static void main(String[] args) {
		JavaUtility javautility=new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://192.168.1.108/domain/Hospital_Management_System/hms/user-login.php");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("patient@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//span[.=' Book Appointment ']")).click();
		driver.findElement(By.xpath("//input[@name='appdate']")).click();
		String reqDate="24-October-2022";
		WebElement currentMonthyear=driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr/th[@class='datepicker-switch']"));
		wait.until(ExpectedConditions.visibilityOf(currentMonthyear));
		String[]arrMonYear=currentMonthyear.getText().split(" ");
		String currentMonth=arrMonYear[0];
		String currentYear=arrMonYear[1];
		
		int currentMonthValue=javautility.convertMonthfromStringtoInt(currentMonth,"MMMM");
		int requiredMonthValue=javautility.convertMonthfromStringtoInt(reqDate.split("-")[2],"MMMM");
		int currentYearvalue=Integer.parseInt(currentYear);
		int requiredYear=Integer.parseInt(reqDate.split("-")[2]);
		while(!(requiredMonthValue==currentMonthValue)&&(currentYearvalue==requiredYear))
		{
			
		}
	}

}











