package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
public class Prac_softassert {

	WebDriver w;
	SoftAssert sft;

	@BeforeTest
	public void preCondition_MutualFund() {

		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Test Case to verify login Page using 'Admin' user", groups = "LoginModule")
	public void loginAdminTest() {
		
		sft=new SoftAssert();

		w.get("http://altoromutual.com:8080/login.jsp");
		
		String loginPageTitle=w.getTitle();
		String loginPageURL=w.getCurrentUrl(); 
		
		WebElement loginPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String loginPageLabel_Text=loginPageLabel.getText();
		
		
		sft.assertEquals(loginPageTitle, "Altoro Mutual");		
		sft.assertTrue(loginPageURL.contains("/login.jsp"), "URL doesn't contains '/login.jsp'");
		sft.assertTrue(loginPageLabel_Text.contains("Login"), "Label doesn't contains 'Login'");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

		sft.assertAll();
	}

	@Test(priority = 1, description = "Test Case to verify logout Page using 'Admin' user", groups = "LoginModule", dependsOnMethods = "loginAdminTest")
	public void logoutAdminTest() throws Exception {
		
		sft=new SoftAssert();
		
		Thread.sleep(2000);
		
		//verify page title "Altoro Home Page"
		//verify page label contain "Admin"
		
		String homePageTitle=w.getTitle();		
		WebElement homePageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String homePageLabel_Text=homePageLabel.getText();
		
		sft.assertEquals(homePageTitle, "Altoro Mutual");
		sft.assertTrue(homePageLabel_Text.contains("Hello Admin User"), "Label doesn't contains 'Admin'");
		
		w.findElement(By.linkText("Sign Off")).click();

		sft.assertAll();
	}

	@AfterTest
	public void postCondition_MutualFund() {
		w.close();
	}

}

