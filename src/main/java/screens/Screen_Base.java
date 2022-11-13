package screens;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;

import java.time.Duration;

import io.appium.java_client.TouchAction;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Screen_Base {
    AppiumDriver driver;

    public static final long WAIT=25;
    public TouchAction actions;


    public Screen_Base(AppiumDriver appiumDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
        driver=appiumDriver;
    }
    public void waitForVisibility(MobileElement element)
    {
        WebDriverWait wait =new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void clear(MobileElement element)
    {
     waitForVisibility(element);
     element.clear();
    }

    public void click(MobileElement element)
    {
        waitForVisibility(element);
        element.click();
    }
    public void sendText(MobileElement element , String text)
    {
        waitForVisibility(element);
        element.sendKeys(text);
    }
    public String getAttribute(MobileElement element,String attribute)
    {
        waitForVisibility(element);
        return element.getAttribute(attribute);

    }
    public void scroll_bottom()
    {
        Dimension dim= driver.manage().window().getSize();
        int scrollStart=(int)(dim.getHeight()*0.8);
        int scrollEnd=(int)(dim.getHeight()*0.1);
        actions=new TouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();


    }
    public void scroll_up()
    {
        Dimension dim= driver.manage().window().getSize();
        int scrollStart=(int)(dim.getHeight()*0.01);
        int scrollEnd=(int)(dim.getHeight()*0.8);
        actions=new TouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();


    }










}
