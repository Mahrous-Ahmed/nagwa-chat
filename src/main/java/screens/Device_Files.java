package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;





public class Device_Files extends Screen_Base{
    public Device_Files(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Photos\"]")
    @iOSXCUITFindBy()
    public MobileElement NativePhotosApp;


    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    @iOSXCUITFindBy()
    public MobileElement photoToSelect;

    public void OpenNativePhotosApp()
    {
        click(NativePhotosApp);
    }

    public void selectPhoto()
    {
        click(photoToSelect);


   }

}
