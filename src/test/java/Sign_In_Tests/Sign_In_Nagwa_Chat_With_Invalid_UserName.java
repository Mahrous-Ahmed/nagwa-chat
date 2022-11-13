package Sign_In_Tests;


import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;

import org.testng.annotations.Test;



import screens.UserName_Validation_Screen;



public class Sign_In_Nagwa_Chat_With_Invalid_UserName extends Test_Base {


    String invalidUserName= ReadProperties.userDate.getProperty("InValid_UserName");
    String ErrorMessageOfUserDoesNotExist= ReadProperties.userDate.getProperty("Error_Message_User_DoesNot_Exist");
    String userNameScreenTitle=ReadProperties.userDate.getProperty("Username_screen_Title");
    String ButtonTextInUsernameScreen =ReadProperties.userDate.getProperty("button_Text_In_UserName_Screen");
    String HintInsideUsernameEmailTextBox =ReadProperties.userDate.getProperty("UserName_Hint_Inside_Text_box");



    UserName_Validation_Screen userNameScreenObject;



    @Test(description = "Check if the user try to sign in with invalid username/email ?")
    @Severity(SeverityLevel.MINOR)
    @Description("Check if the user try to sign in with invalid username/email ?")
    public void Sign_In_With_Invalid_Username_Or_Email()  {
        userNameScreenObject=new UserName_Validation_Screen(driver);
        Assert.assertEquals(userNameScreenObject.Title_Of_UserName_Screen.getText(),userNameScreenTitle);
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertEquals(userNameScreenObject.UserName_Text_Box.getText(), HintInsideUsernameEmailTextBox);
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(), ButtonTextInUsernameScreen);
        Assert.assertTrue(userNameScreenObject.UserName_Text_Box.isDisplayed());
        userNameScreenObject.enterUserName(invalidUserName);
        userNameScreenObject.clickNext();
        Assert.assertEquals(userNameScreenObject.Error_message_user_doesNot_Exist.getText(),ErrorMessageOfUserDoesNotExist);
        userNameScreenObject.clear(userNameScreenObject.UserName_Text_Box);


    }




}
