package com.testpages.differentfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	static WebDriver d = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KillZone\\Downloads\\Softwares\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		WebElement smallCircle = d.findElement(By.id("draggable"));
		WebElement targetElement = d.findElement(By.id("droptarget"));
		
		Actions act = new Actions(d);
		act.dragAndDrop(smallCircle, targetElement).build().perform();
		
		Thread.sleep(1000);
		
		if(targetElement.getText().equalsIgnoreCase("You did great!"))
				System.out.println("PASS");
		else
				System.out.println("FAIL");
		
		
		
		d.close();

	}
	
}
