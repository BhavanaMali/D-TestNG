package com.itview.testcases.selenium_testing_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintestcase {
	
	
	public static void main(String[]args) throws Exception{
		//interfaceName instance implementClass();
		WebDriver w= new ChromeDriver(); //open blank browser-chrome
		
		//Step 1 : Open application with url
		w.get("http://altoromutual.com:8080/login.jsp");
		// Step 2 : Enter username
		w.findElement(By.id("uid")).sendKeys("admin");
		 //Step 3 : Enter Password
		w.findElement(By.id("passw")).sendKeys("admin");
		// Step 4: Click login
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		 // Step 5: Click Logout
		w.findElement(By.linkText("Sign Off")).click();

	      //Step 6 : Close
		w.close();
		
		System.out.println("Tested Admin login for Altromutual successfully !");
		
	}

}
