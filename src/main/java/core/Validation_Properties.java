package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Validation_Properties {

	public static void main(String[] args) {
		String tcase_id = null;
		String url = null;
		String exp_title = null;
		
		Properties properties_file = new Properties();
		
		try {
			properties_file.load(new FileInputStream ("./../src/main/resources/Test.properties"));
			
			tcase_id = properties_file.getProperty("tc_id");
			url = properties_file.getProperty("url");
			exp_title = properties_file.getProperty("expected_title");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WebDriver dr = new HtmlUnitDriver();
		dr.get(url);
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String act_title = dr.getTitle();
		System.out.println("");
		
		System.out.println("File name:\t\t\"Multiple_Title_Validation.java\"");
		System.out.println("Test CaseID: \t\t" + tcase_id);
		System.out.println("URL: \t\t\t" + url);
		System.out.println("Expected Title: \t" + exp_title);
		System.out.println("Actual Title: \t\t" + act_title);
		
		if (exp_title.equals(act_title)) {
			System.out.println("Test Case Result: \t" + "PASSED");
		}else {
			System.out.println("Test Case Result: \t" + "FAILED");
		}
			
		dr.quit();
		

	}

}
