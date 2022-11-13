package Sign_In_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_List_Screen;
import screens.Password_Validation_Screen;
import screens.UserName_Validation_Screen;

import java.util.concurrent.TimeUnit;

public class Sign_In_Nagwa_Chat_Educator extends Test_Base {

    UserName_Validation_Screen userNameScreenObject;
    Password_Validation_Screen passwordValidationScreen;
    Chat_List_Screen chatListScreenObject;


    String userNameScreenTitle=ReadProperties.userDate.getProperty("Username_screen_Title");
    String EmailOfEducator=ReadProperties.userDate.getProperty("UserNameOfEducator");
    String passwordOfEducator=ReadProperties.userDate.getProperty("PasswordOfEducator");
    String HintInsideUsernameEmailTextBox =ReadProperties.userDate.getProperty("UserName_Hint_Inside_Text_box");
    String ButtonTextInUsernameScreen =ReadProperties.userDate.getProperty("button_Text_In_UserName_Screen");
    String TitleOfPasswordScreen = ReadProperties.userDate.getProperty("Password_Screen_Title");
    String HintInsidePasswordTextBox =ReadProperties.userDate.getProperty("Password_Hint_Inside_Text_box");
    String ButtonTextInPasswordScreen=ReadProperties.userDate.getProperty("button_Text_In_Password_Screen");
    String chatListScreenTitle=ReadProperties.userDate.getProperty("ChatListScreenTitle");


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Sign in with valid Email")
    public void enter_Valid_Email()  {

        userNameScreenObject=new UserName_Validation_Screen(driver);
        Assert.assertEquals(userNameScreenObject.Title_Of_UserName_Screen.getText(),userNameScreenTitle);
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertEquals(userNameScreenObject.UserName_Text_Box.getText(), HintInsideUsernameEmailTextBox);
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(), ButtonTextInUsernameScreen);
        Assert.assertTrue(userNameScreenObject.UserName_Text_Box.isDisplayed());
        userNameScreenObject.enterUserName(EmailOfEducator);
        userNameScreenObject.clickNext();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        passwordValidationScreen=new Password_Validation_Screen(driver);
        Assert.assertTrue(passwordValidationScreen.back_button.isEnabled());
        Assert.assertEquals(passwordValidationScreen.sign_in_title.getText(), TitleOfPasswordScreen);
        Assert.assertTrue(passwordValidationScreen.password_screen_logo.isDisplayed());
        Assert.assertEquals(passwordValidationScreen.entered_UserName.getText(),EmailOfEducator);
        Assert.assertEquals(passwordValidationScreen.password_text_field.getText(), HintInsidePasswordTextBox);
        Assert.assertTrue(passwordValidationScreen.show_password.isDisplayed());
        Assert.assertEquals(passwordValidationScreen.sign_in_button.getText(),ButtonTextInPasswordScreen);
    }

    @Test(dependsOnMethods = "enter_Valid_Email")
    @Severity(SeverityLevel.BLOCKER)
    @Description("sign in nagwa chat by valid password")
    public void enter_Valid_Password()  {
        passwordValidationScreen.enterPassword(passwordOfEducator);
        passwordValidationScreen.viewPassword();
        passwordValidationScreen.clickSignIn();
        chatListScreenObject=new Chat_List_Screen(driver);
        Assert.assertTrue(chatListScreenObject.profileIcon.isDisplayed());
        Assert.assertEquals(chatListScreenObject.ScreenTitle.getText(),chatListScreenTitle);
        Assert.assertFalse(chatListScreenObject.chatList.isEmpty());


    }
}
