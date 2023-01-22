package com.itview.testcases.selenium_testing_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcase_cssOrange {
public static void main(String[] args) throws Exception{
		
		//interfaceName instance implementClass();
				WebDriver w= new ChromeDriver(); //open blank browser-chrome
				
				//Step 1 : Open application with url
				w.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
				Thread.sleep(2000);
				// Step 2 : Enter username //Syntax :* id = tagName#id
				w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
				 //Step 3 : Enter Password //syntax:name / type /value =  tagName[attribute='data']
				w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
				// Step 4: Click login //syntax:classname - tagName.classname
				w.findElement(By.cssSelector("input.button")).click();
				 // Step 5: Click Logout
				

			      //Step 6 : Close
				w.close();
				
				System.out.println("Invalid user!");
		

	}

}


