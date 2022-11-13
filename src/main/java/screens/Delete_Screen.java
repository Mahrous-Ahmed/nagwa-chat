package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Alert;

public class Delete_Screen extends Screen_Base{
    public Delete_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.nagwa.chat:id/ltMessage")
    @iOSXCUITFindBy()
    public MobileElement MessageBox;

    @AndroidFindBy(id = "com.nagwa.chat:id/ltDelete")
    @iOSXCUITFindBy()
    public MobileElement DeleteButton;


    public void deleteMessage()
    {
        click(DeleteButton);
    }
    public void ConfirmDelete()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
