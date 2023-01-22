package com.itview.testcases.selenium_testing_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestcases_Xmlpath {

	public static void main(String[] args) throws Exception
	{
		WebDriver w=new ChromeDriver();
		        //Step 1 : Open application with url
				w.get("http://altoromutual.com:8080/login.jsp");
				Thread.sleep(2000);
				// Step 2 : Enter username
				w.findElement(By.xpath("//*[@id=\"uid\"]")).sendKeys("admin");
				Thread.sleep(2000);
				 //Step 3 : Enter Password
				w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys("admin");
				Thread.sleep(2000);
				// Step 4: Click login
				w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
				Thread.sleep(2000);
				// Step 5: Click Logout
				w.findElement(By.xpath("/html/body/div[1]/form/table/tbody/tr[1]/td[2]/a[1]/font")).click();
				Thread.sleep(2000);
				//Step 6 : Close
				w.close();
				
				System.out.println("Tested Admin log in X-Path successfully !");
		

	}

}
