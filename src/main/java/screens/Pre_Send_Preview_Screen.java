package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Pre_Send_Preview_Screen extends Screen_Base{
    public Pre_Send_Preview_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.nagwa.chat:id/ivTrashButton")
    @iOSXCUITFindBy()
    public MobileElement trashIcon;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivCancelButton")
    @iOSXCUITFindBy()
    public MobileElement closeIcon;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivSendButton")
    @iOSXCUITFindBy()
    public MobileElement sendButton;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivAddPhoto")
    @iOSXCUITFindBy()
    public MobileElement AddPhotoButton;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivCurrentImage")
    @iOSXCUITFindBy()
    public MobileElement currentImage;




    public void send_Photo()
    {
        click(sendButton);
    }
    public void Add_New_Photo()
    {
        click(AddPhotoButton);
    }
    public void close_Preview_Screen()
    {
        click(closeIcon);
    }
    public void delete_Photo()
    {
        click(trashIcon);
    }







}
