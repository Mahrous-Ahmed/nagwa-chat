package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Devices_Photos extends Screen_Base{
    public Devices_Photos(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    @iOSXCUITFindBy()
    public MobileElement photosFolder;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Camera']")
    @iOSXCUITFindBy()
    public MobileElement cameraFolder;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Screenshots']")
    @iOSXCUITFindBy()
    public MobileElement screenShotFolder;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Download']")
    @iOSXCUITFindBy()
    public MobileElement downloadFolder;


    public void openPhotosFolder()
    {
        click(photosFolder);
    }
    public void openCameraFolder()
    {
        click(cameraFolder);
    }
    public void openScreenShotFolder()
    {
        click(screenShotFolder);
    }
    public void openDownloadFolder()
    {
        click(downloadFolder);
    }

}
