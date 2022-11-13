package Sign_In_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Password_Validation_Screen;
import screens.UserName_Validation_Screen;



public class Sign_In_Nagwa_Chat_with_Invalid_Password extends Test_Base {

    UserName_Validation_Screen userNameScreenObject;
    Password_Validation_Screen passwordValidationScreen;

    String ErrorMessageOfInValidPassword=ReadProperties.userDate.getProperty("Error_Message_InValid_Password");
    String UsernameScreenTitle=ReadProperties.userDate.getProperty("Username_screen_Title");
    String ButtonTextInUserNameScreen=ReadProperties.userDate.getProperty("button_Text_In_UserName_Screen");

    String TitleOfPasswordScreen = ReadProperties.userDate.getProperty("Password_Screen_Title");


    String userNameOfStudent=ReadProperties.userDate.getProperty("UserNameOfStudent");


    String HintInsidePasswordTextBox =ReadProperties.userDate.getProperty("Password_Hint_Inside_Text_box");
    String ButtonTextInPasswordScreen=ReadProperties.userDate.getProperty("button_Text_In_Password_Screen");


    String invalidPassword="214565";

    @Parameters({"ValidUserName"})
    @Test(description = "Check if the user sign in with valid username/email ?")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check if the user sign in with valid username/email ?")
    public void Sign_In_With_Valid_Username_Or_Email(String ValidUserName)  {

        userNameScreenObject=new UserName_Validation_Screen(driver);
        Assert.assertEquals(userNameScreenObject.Title_Of_UserName_Screen.getText(),UsernameScreenTitle);
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.Next_Step_Button.isEnabled());
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(),ButtonTextInUserNameScreen);
        userNameScreenObject.enterUserName(ValidUserName);
        userNameScreenObject.clickNext();
        passwordValidationScreen=new Password_Validation_Screen(driver);
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.textToBePresentInElement(passwordValidationScreen.entered_UserName,userNameOfStudent));
        Assert.assertTrue(passwordValidationScreen.back_button.isEnabled());
        Assert.assertEquals(passwordValidationScreen.sign_in_title.getText(), TitleOfPasswordScreen);
        Assert.assertTrue(passwordValidationScreen.password_screen_logo.isDisplayed());
        Assert.assertEquals(passwordValidationScreen.entered_UserName.getText(),userNameOfStudent);
        Assert.assertEquals(passwordValidationScreen.password_text_field.getText(), HintInsidePasswordTextBox);
        Assert.assertTrue(passwordValidationScreen.show_password.isDisplayed());
        Assert.assertEquals(passwordValidationScreen.sign_in_button.getText(),ButtonTextInPasswordScreen);

    }
    @Test(dependsOnMethods = "Sign_In_With_Valid_Username_Or_Email",description = "Check if the user sign in with invalid password ?")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if the user sign in with invalid password ?")
    public void Sign_In_With_Invalid_Password() {
        passwordValidationScreen.enterPassword(invalidPassword);
        passwordValidationScreen.clickSignIn();
        Assert.assertEquals(passwordValidationScreen.Error_message_password_Screen.getText(),ErrorMessageOfInValidPassword);
        passwordValidationScreen.clear(passwordValidationScreen.password_text_field);
    }



    @Test(dependsOnMethods = "Sign_In_With_Invalid_Password",description = "Check the back Key to return to username/email screen ?")
    @Severity(SeverityLevel.MINOR)
    @Description("Check the back Key to return to username/email screen ?")
    public  void Back_To_UserName_Screen()
    {
        passwordValidationScreen.clickBack();
        Assert.assertEquals(userNameScreenObject.Title_Of_UserName_Screen.getText(),UsernameScreenTitle);
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.Next_Step_Button.isEnabled());
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(),ButtonTextInUserNameScreen);

    }
}
