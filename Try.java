package org.Project.FitPeo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class Try {

	
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\chand\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	    
	    driver.get("https://www.fitpeo.com/");
	    WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator")); 
	    revenueCalculatorLink.click();
	   
	    Thread.sleep(3000);
	    //scroll down
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("window.scrollBy(0,500)","");
	    
	   //adjust the sliderbar
	    Actions actions = new Actions(driver);
	    WebElement slider = driver.findElement(By.className("MuiSlider-thumb")); 
	   
	    actions.dragAndDropBy(slider,93,0).perform();
	    
	    //input field with slider
	    WebElement textField = driver.findElement(By.id(":r0:")); 
	    String textFieldValue = textField.getAttribute("value");
	    if ("816".equals(textFieldValue)) 
	    {   
	    	System.out.println("Slider value is correctly updated to 820."); 
	    	}
	    else {
	    	System.out.println("Failed to update slider value. Current value: " + textFieldValue); 
	    	}
	    WebElement slidercolor = driver.findElement(By.className("css-16i48op"));
	    js.executeScript("arguments[0].style.backgroundColor = 'red';", slidercolor);
	    
	    textField.click();
	    
	    for (int i=0; i<3; i++ ) {
	    textField.sendKeys(Keys.BACK_SPACE);}
	    Thread.sleep(1000);
	    textField.sendKeys("560");
	    String textFieldValue1 = textField.getAttribute("value");
	    
	    if ("560".equals(textFieldValue1)) 
	    {   
	    	System.out.println("Slider is correctly updated"); 
	    	}
	    else {
	    	System.out.println("Failed to update slider"); 
	    	}
	    
	    //scroll down
	    js.executeScript("window.scrollBy(500,500)","");
        Thread.sleep(1000);
	    
	  // Step 6: Select CPT Codes
	  List<WebElement> cptCheckbox = driver.findElements(By.className("css-1m9pwf3"));
      List<String> cptCodes = Arrays.asList("CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474");
	   for(WebElement w:cptCheckbox) {
        	
        	 String elementType = w.getAttribute("type");
             if ("checkbox".equalsIgnoreCase(elementType)) {
            	 System.out.println(w);
            	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
            	 WebElement parentElement = ((w.findElement(By.xpath(".."))).findElement(By.xpath(".."))).findElement(By.xpath(".."));
            	 WebElement e = parentElement.findElement(By.className("css-1s3unkt"));
            	
            	 String text = e.getText();
            	 
                 if(cptCodes.contains(text)) {
                	 js1.executeScript("arguments[0].checked = true;", w);
                     js1.executeScript("arguments[0].click();", w);
                 }
                
                 
                 if (w.isSelected()) {
                     System.out.println("Checkbox is now checked.");
                 } else {
                     System.out.println("Checkbox is still unchecked.");
                 }
                
                 
             }
      
        }
	 
        
        Thread.sleep(3000);

       //step7 total value
   	WebElement e1 = driver.findElement(By.className("css-1bl0tdj"));
	 String actualReimbursement = e1.getText();
        String expectedReimbursement = "$110700";
        if (actualReimbursement.contains(expectedReimbursement)) {
            System.out.println("Test Passed: Total Recurring Reimbursement is " + actualReimbursement);
        } else {
            System.out.println("Test Failed: Total Recurring Reimbursement is " + actualReimbursement);
       
 
		}
        
         driver.quit();
       }
	    }
		
	
	    
	    
	


