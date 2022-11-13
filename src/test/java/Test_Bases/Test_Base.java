package Test_Bases;

import Utilities.Helper;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;



import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Test_Base {
    public static AppiumDriver<MobileElement> driver=null;


     @BeforeSuite(description = "Open Nagwa chat app")
     @Parameters({"browserstack.user","browserstack.key","platformName","udid","device","os_version","app","project","build","name","url"})
     @Severity(SeverityLevel.BLOCKER)
     public void Start_Nagwa_Chat_App(String browserStackUser,String browserStackKey,String platformName,String udid,String device,String version,String app,String projectName,String buildNumber ,String sessionName,String url) throws MalformedURLException {

         DesiredCapabilities caps=new DesiredCapabilities();
         caps.setCapability("browserstack.user",browserStackUser);
         caps.setCapability("browserstack.key",browserStackKey);
         caps.setCapability("platformName",platformName);
         caps.setCapability("udid",udid);
         caps.setCapability("device",device);
         caps.setCapability("os_version",version);
         caps.setCapability("app", app);
         caps.setCapability("project",projectName);
         caps.setCapability("build",buildNumber);
         caps.setCapability("name",sessionName);
         caps.setCapability("browserstack.uploadMedia",new String[]{"media://148077348bfb105b4f6b79d2bb9ea732478b74bf"});







         driver=new AppiumDriver<>(new URL(url),caps);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


     }


    @AfterMethod
    public void Take_Screenshot(ITestResult results)
    {
        if (results.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("fail......!");
            System.out.println("taking screenshot........");
            Helper.Capture_Screenshot_On_Failure(driver, results.getName());


        }


    }








    @AfterSuite
    public void close_App()
    {
      driver.closeApp();
      driver.quit();
    }
}
