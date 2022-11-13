package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Password_Validation_Screen extends Screen_Base{
    public Password_Validation_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "back")
    public MobileElement back_button;

    @AndroidFindBy(id = "txtHeaderTitle")
    @iOSXCUITFindBy(accessibility = "Sign In")
    public MobileElement sign_in_title;

    @AndroidFindBy(id = "signInLogoImg")
    @iOSXCUITFindBy(accessibility = "logo")
    public MobileElement password_screen_logo;

    @AndroidFindBy(id = "txtUserEmail")
    @iOSXCUITFindBy(accessibility = "usericon")
    public MobileElement entered_UserName;

    @AndroidFindBy(id = "signInPasswordEt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Nagwa Chat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
    public MobileElement password_text_field;

    @AndroidFindBy(id = "text_input_end_icon")
    @iOSXCUITFindBy(accessibility = "showpass selected")
    public MobileElement show_password;

    @AndroidFindBy(id = "signInBtn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN IN\"]")
    public MobileElement sign_in_button;



    @AndroidFindBy(id = "txtError")
    @iOSXCUITFindBy(accessibility = "The password you have entered is invalid. Please double-check your password and try again.")
    public MobileElement Error_message_password_Screen;



    public void clickBack()
    {
        click(back_button);
    }
    public void enterPassword(String password)
    {
        clear(password_text_field);
        sendText(password_text_field,password);
    }
    public void viewPassword()
    {
        click(show_password);
    }
    public void clickSignIn()
    {
        click(sign_in_button);
    }
}
