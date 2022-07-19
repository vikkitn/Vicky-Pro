package org.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot extends BaseClass{
	@Test
	public void screenshot() throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./Screen/amazon.png"));
		
	}

}
