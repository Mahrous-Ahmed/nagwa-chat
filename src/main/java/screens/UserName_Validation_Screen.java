package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;



public class UserName_Validation_Screen extends Screen_Base {
    public UserName_Validation_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    @AndroidFindBy(id = "txtHeaderTitle")
    @iOSXCUITFindBy(accessibility = "Sign In")
    public MobileElement Title_Of_UserName_Screen;

    @AndroidFindBy(id = "signInLogoImg")
    @iOSXCUITFindBy(accessibility = "logo")
    public MobileElement Logo_Of_UserName_Screen;

    @AndroidFindBy(id = "emailEt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Nagwa Chat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    public MobileElement UserName_Text_Box;

    @AndroidFindBy(id = "verifyEmailBtn")
    @iOSXCUITFindBy(accessibility = "NEXT STEP")
    public MobileElement Next_Step_Button;

    @AndroidFindBy(id = "com.nagwa.chat:id/progressEmailStep")
    @iOSXCUITFindBy()
    public MobileElement progressEmailStep;


    @AndroidFindBy(id = "txtError")
    @iOSXCUITFindBy(accessibility = "Please fill in the required field and try again.")
    public MobileElement Error_message_UserName;

    @AndroidFindBy(id = "txtError")
    @iOSXCUITFindBy(accessibility = "This username doesn't exist.")
    public MobileElement Error_message_user_doesNot_Exist;


    public void enterUserName(String userName) {
        clear(UserName_Text_Box);
        sendText(UserName_Text_Box, userName);
    }

    public void clickNext() {
        click(Next_Step_Button);
    }




}
