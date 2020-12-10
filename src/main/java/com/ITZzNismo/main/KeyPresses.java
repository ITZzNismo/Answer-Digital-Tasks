package com.ITZzNismo.main;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPresses 
{
	private static WebDriver driver;

	// Sets the Chrome driver property and fetches the web site
	@BeforeClass
	public static void setup() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/key_presses");

	}
	
	// Finds the input box, presses the left control key and asserts that it has accepted the input
	@Test
	public void keyOne()
	{
		WebElement keyOne = driver.findElement(By.id("target"));
		keyOne.click();
		keyOne.sendKeys(Keys.LEFT_CONTROL);
		String expected = "You entered: CONTROL";
		String actual = driver.findElement(By.id("result")).getText();
		assertEquals(expected, actual);
	}

	// Finds the input box, presses the left alt key and asserts that it has accepted the input
	@Test
	public void keyTwo()
	{
		WebElement keyOne = driver.findElement(By.id("target"));
		keyOne.click();
		keyOne.sendKeys(Keys.LEFT_ALT);
		String expected = "You entered: ALT";
		String actual = driver.findElement(By.id("result")).getText();
		assertEquals(expected, actual);
	}
	
	// Finds the input box, presses the space key and asserts that it has accepted the input
	@Test
	public void keyThree()
	{
		WebElement keyOne = driver.findElement(By.id("target"));
		keyOne.click();
		keyOne.sendKeys(Keys.SPACE);
		String expected = "You entered: SPACE";
		String actual = driver.findElement(By.id("result")).getText();
		assertEquals(expected, actual);
	}
	
	// Finds the input box, presses the shift key and asserts that it has accepted the input
	@Test
	public void keyFour()
	{
		WebElement keyOne = driver.findElement(By.id("target"));
		keyOne.click();
		keyOne.sendKeys(Keys.LEFT_SHIFT);
		String expected = "You entered: SHIFT";
		String actual = driver.findElement(By.id("result")).getText();
		assertEquals(expected, actual);
	}
}
