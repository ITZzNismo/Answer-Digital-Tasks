package com.ITZzNismo.main;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAuthentication 
{
	private static WebDriver driver;

	// Sets the Chrome driver property and fetches the web site
	@BeforeClass
	public static void setup() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login");
	}

	// Finds the username and password input fields, as well as the submit button, and inputs the correct username but wrong password
	@Test
	public void formAuthenticationTest1() 
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.cssSelector("button"));
		username.sendKeys(Keys.chord("tomsmith"));
		password.sendKeys(Keys.chord("SuperSecretWrongPassword"));
		submit.click();
	}

	// Asserts that the element contains the expected String
	@Test
	public void assertLoginFailureOne() throws InterruptedException 
	{
		Thread.sleep(5000);
		String expected = "Your password is invalid!";
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/text()")).getText();
		assertEquals(expected, actual);
	}

	// Finds the username and password input fields, as well as the submit button, and inputs the correct password but wrong username
	@Test
	public void formAuthenticationTest2() 
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.cssSelector("button"));
		username.sendKeys(Keys.chord("johnsmith"));
		password.sendKeys(Keys.chord("SuperSecretPassword!"));
		submit.click();
	}

	// Asserts that the element contains the expected String
	@Test
	public void assertLoginFailureTwo() throws InterruptedException 
	{
		Thread.sleep(5000);
		String expected = "Your username is invalid!";
		String actual = driver.findElement(By.xpath("//*[@id=\"flash\"]/text()")).getText();
		assertEquals(expected, actual);
	}	
	
	// Finds the username and password input fields, as well as the submit button, to then input the correct password and username and logout
	@Test
	public void formAuthenticationTest3() throws InterruptedException 
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.cssSelector("button"));
		username.sendKeys(Keys.chord("tomsmith"));
		password.sendKeys(Keys.chord("SuperSecretPassword!"));
		submit.click();
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		logout.click();
	}
}
