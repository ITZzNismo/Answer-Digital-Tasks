package com.ITZzNismo.main;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfiniteScroll 
{
	private static WebDriver driver;
	
	// Sets the Chrome driver property and fetches the web site
	@BeforeClass
	public static void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/infinite_scroll");
	}
	
	// For loop to scroll down the web page twice and once out of the loop, scrolls up once and waits in between each scroll
	@Test
	public void infiniteScrollTest() throws InterruptedException
	{   
		WebElement scroll = driver.findElement(By.xpath("/html/body"));
        for (int i = 0; i < 2; i++) 
        {   		
			Thread.sleep(2000);
			scroll.sendKeys(Keys.PAGE_DOWN);        	
		}
        Thread.sleep(2000);
        scroll.sendKeys(Keys.PAGE_UP);
	}
	
	// Tests to find the name of an element called "Infinite Scroll"
	@Test
	public void assertInfiniteScrollTest() throws InterruptedException
	{
		String expected = "Infinite Scroll";
		WebElement actual = driver.findElement(By.name("Infinite Scroll"));
		assertEquals(expected, actual);
	}
}