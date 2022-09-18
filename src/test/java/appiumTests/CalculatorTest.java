package appiumTests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import dev.failsafe.internal.util.Assert;

public class CalculatorTest extends Base {	
	
	@Test
	public void additionTest() throws MalformedURLException {
		
		//add logs for extent report
		ExtentTest test = extentReport.createTest("Calculator Addition Test", "Testing addition operation");
		
		// Test calculator addition operation
		WebElement oneBtn = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
		WebElement addBtn = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		WebElement twoBtn = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
//		WebElement threeBtn = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
//		WebElement equalBtn = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		
		// perform action
		oneBtn.click();
		addBtn.click();
		twoBtn.click();
		
		String ansFromScreen = result.getText();
		Assert.isTrue(ansFromScreen.contains("3"), "Test passed");
		System.out.println("Addition result is: " + ansFromScreen);
		
	}

}
