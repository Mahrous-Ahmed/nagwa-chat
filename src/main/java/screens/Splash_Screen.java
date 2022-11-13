package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class Splash_Screen extends Screen_Base{
    public Splash_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy()
    @iOSXCUITFindBy()
    MobileElement a ;

    @AndroidFindBy()
    @iOSXCUITFindBy()
    MobileElement b;

    @AndroidFindBy()
    List<MobileElement> chat_Groups;
}
