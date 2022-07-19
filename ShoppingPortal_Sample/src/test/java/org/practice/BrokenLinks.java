package org.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks extends BaseClass{

	@Test
	public void brokenLinks() {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.olacabs.com/");*/
		List<WebElement>allLinks=driver.findElements(By.xpath("//a"));
	    List<String>list=new ArrayList<>();
	    for(WebElement link:allLinks)
	    {
	    	String linkString=link.getAttribute("href");
	    	list.add(linkString);
	    	list.remove(null);
	    	list.size();
	    }
		for(String links:list)
		{
			System.out.println(links);
			URL url;
			try {
				url = new URL(links);
				HttpURLConnection responce;
				try {
					responce = (HttpURLConnection)url.openConnection();
					int statuscode = responce.getResponseCode();
					if(statuscode!=200)
					{
						System.out.println(links+"===>  "+statuscode+"===>"+responce.getResponseMessage());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int statuscode;
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		System.out.println(list.size());
	}

}
