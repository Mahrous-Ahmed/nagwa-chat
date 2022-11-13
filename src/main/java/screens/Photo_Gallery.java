package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Photo_Gallery extends Screen_Base{
    public Photo_Gallery(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id="com.nagwa.chat:id/ivCancelButton")
    @iOSXCUITFindBy()
    public MobileElement closeButton;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivShadow")
    @iOSXCUITFindBy()
    public MobileElement shadow;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivPhoto")
    @iOSXCUITFindBy()
    public MobileElement photoInGallery;

    public void closeGallery()
    {
        click(closeButton);
    }


}
