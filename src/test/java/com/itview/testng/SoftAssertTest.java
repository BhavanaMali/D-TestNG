package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertTest {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void precondition_MutualFund() {
	  w= new ChromeDriver();
  }
  
  @Test(priority = 0, description = "Test Case to verify login Page using 'Admin' user", groups = "LoginModule")
	public void loginAdminTest()
  {
	  sft=new SoftAssert();
	  
	  w.get("http://altoromutual.com:8080/login.jsp");
	  String LoginPageTitel=w.getTitle();
	  String LoginPageURL=w.getCurrentUrl();
	  
	  WebElement LoginLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String LoginPageLabel_Text=LoginLabel.getText();
	  
	  
	   
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		sft.assertEquals(LoginPageTitel, "Altoro Mutual");
		sft.assertTrue(LoginPageURL.contains("/login.jsp"), "URL doesn't contains '/login.jsp'");
		sft.assertTrue(LoginPageLabel_Text.contains("Login"), "Label doesn't contains 'Login'");
		
		sft.assertAll();
  }
  @Test(priority = 1, description = "Test Case to verify logout Page using 'Admin' user", groups = "LoginModule", dependsOnMethods = "loginAdminTest")
	public void logoutAdminTest() throws Exception 
  {
	  sft=new SoftAssert();
	  Thread.sleep(2000);
	  
	  String homePageTitle=w.getTitle();		
	  WebElement homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  String homePageLabel_Text=homePageLabel.getText();
		
	  sft.assertEquals(homePageTitle, "Altoro Mutual");
	  sft.assertTrue(homePageLabel_Text.contains("Admin"), "Label doesn't contains 'Admin'");
	  w.findElement(By.linkText("Sign Off")).click();
	  sft.assertAll();

  }

  @AfterTest
  public void postcondition_MutualFund() {
	  w.close();
  }

}
