package Sign_In_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.UserName_Validation_Screen;




public class Sign_In_Nagwa_Chat_With_Empty_UserName extends Test_Base {

    UserName_Validation_Screen userNameScreenObject;
    String ErrorMessageOfEmptyUsername =ReadProperties.userDate.getProperty("Error_Message_Of_Empty_user_name");
    String UsernameScreenTitle=ReadProperties.userDate.getProperty("Username_screen_Title");
    String ButtonTextInUserNameScreen=ReadProperties.userDate.getProperty("button_Text_In_UserName_Screen");





    @Test(description = "Check if the User sign in with empty username ?")
    @Severity(SeverityLevel.MINOR)
    @Description("Check if the User sign in with empty username ?")
    public void Sign_In_With_Empty_Username_Or_Email() {
        userNameScreenObject = new UserName_Validation_Screen(driver);
        Assert.assertEquals(userNameScreenObject.Title_Of_UserName_Screen.getText(),UsernameScreenTitle);
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.Next_Step_Button.isEnabled());
        Assert.assertEquals(userNameScreenObject.Next_Step_Button.getText(),ButtonTextInUserNameScreen);
        userNameScreenObject.enterUserName("");
        userNameScreenObject.clickNext();
        Assert.assertEquals(userNameScreenObject.Error_message_UserName.getText(),ErrorMessageOfEmptyUsername);
    }

}
