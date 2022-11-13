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

public class Sign_In_Nagwa_Chat_With_Empty_Password extends Test_Base {

    UserName_Validation_Screen userNameScreenObject;
    Password_Validation_Screen passwordValidationScreen;

    String ErrorMessageOfEmptyUsername =ReadProperties.userDate.getProperty("Error_Message_Of_Empty_user_name");
    String buttonTestInUserNameScreen=ReadProperties.userDate.getProperty("button_Text_In_UserName_Screen");
    String userNameOfStudent=ReadProperties.userDate.getProperty("UserNameOfStudent");
    String TitleOfPasswordScreen = ReadProperties.userDate.getProperty("Password_Screen_Title");
    String HintInsidePasswordTextBox =ReadProperties.userDate.getProperty("Password_Hint_Inside_Text_box");
    String ButtonTextInPasswordScreen=ReadProperties.userDate.getProperty("button_Text_In_Password_Screen");


    @Test
    @Parameters({"ValidUserName"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("Sign in with valid user name")
    public void enter_Valid_User_Name(String ValidUserName)  {

        userNameScreenObject=new UserName_Validation_Screen(driver);
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
    @Test(dependsOnMethods = "enter_Valid_User_Name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that if the user enter empty password ")
    public void enter_Empty_Password()
    {
        passwordValidationScreen.enterPassword("");
        passwordValidationScreen.clickSignIn();
        Assert.assertEquals(userNameScreenObject.Error_message_UserName.getText(),ErrorMessageOfEmptyUsername);

    }
    @Test(dependsOnMethods = "enter_Empty_Password")
    @Severity(SeverityLevel.MINOR)
    @Description("Back to userName screen")
    public  void back_to_UserName_screen()
    {
        passwordValidationScreen.clickBack();
        Assert.assertTrue(userNameScreenObject.Title_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isEnabled());
        Assert.assertTrue(userNameScreenObject.UserName_Text_Box.isEnabled());
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(),buttonTestInUserNameScreen);

    }
}
