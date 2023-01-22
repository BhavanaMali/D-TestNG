package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PracHardassert {

	WebDriver w;

	@BeforeTest
	public void preCondition_MutualFund() {

		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test Case to verify login Page using 'Admin' user", groups = "LoginModule")
	public void loginAdminTest() {

		w.get("http://altoromutual.com:8080/login.jsp");
		
		String loginPageTitle=w.getTitle();
		String loginPageURL=w.getCurrentUrl(); 
		
		WebElement loginPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String loginPageLabel_Text=loginPageLabel.getText();
		
		WebElement loginButton=w.findElement(By.cssSelector("input[value='Login']"));
		
		Assert.assertEquals(loginPageTitle, "Altoro Mutual");		
		Assert.assertTrue(loginPageURL.contains("/login.jsp"), "URL doesn't contains '/login.jsp'");
		Assert.assertTrue(loginPageLabel_Text.contains("Login"), "Label doesn't contains 'Login'");
		
		Assert.assertTrue(loginButton.isDisplayed(), "Login Button not available on login page");
		
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

	}

	@Test(priority = 1, description = "Test Case to verify logout Page using 'Admin' user", groups = "LoginModule", dependsOnMethods = "loginAdminTest")
	public void logoutAdminTest() throws Exception {

		Thread.sleep(2000);
		
		//verify page title "Altoro Home Page"
		//verify page label contain "Admin"
		
		String homePageTitle=w.getTitle();		
		WebElement homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String homePageLabel_Text=homePageLabel.getText();
		
		WebElement SignOff_Object=w.findElement(By.xpath("//*[text()='Sign Off']"));
		
		Assert.assertEquals(homePageTitle, "Altoro Mutual");
		Assert.assertTrue(homePageLabel_Text.contains("Admin"), "Label doesn't contains 'Admin'");
		Assert.assertTrue(SignOff_Object.isDisplayed(), "SignOff Object not present on Home Page");
		
		w.findElement(By.linkText("Sign Off")).click();

	}

	@AfterTest
	public void postCondition_MutualFund() {
		w.close();
	}

}
