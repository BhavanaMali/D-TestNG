package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestCase {
	WebDriver w;
	  @BeforeTest
	  public void precondition() {
		  w= new ChromeDriver();
	  }
		
  @Test
  public void f() {
	  
	
			w.get("http://altoromutual.com:8080/login.jsp");
			w.findElement(By.id("uid")).sendKeys("admin");
			w.findElement(By.id("passw")).sendKeys("admin");
			w.findElement(By.name("btnSubmit")).click();
			w.findElement(By.linkText("Sign Off")).click();

  }
  
  @AfterTest
  public void postcondition() {
	  w.close();
  }

}
