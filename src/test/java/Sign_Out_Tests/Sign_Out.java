package Sign_Out_Tests;

import Test_Bases.Test_Base;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_List_Screen;
import screens.UserName_Validation_Screen;

public class Sign_Out extends Test_Base {
    Chat_List_Screen chatListScreenObject;
    UserName_Validation_Screen userNameScreenObject;

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("user can sign out from nagwa chat")
    public void Sign_Out_Nagwa_Chat()
    {
        chatListScreenObject=new Chat_List_Screen(driver);
        chatListScreenObject.OpenProfileMenu();
        Assert.assertTrue(chatListScreenObject.signOutBtnInSignOutPopUp.isEnabled());
        Assert.assertTrue(chatListScreenObject.cancelBTNInSignOutPopUP.isEnabled());
        Assert.assertTrue(chatListScreenObject.studentNameInSignOutPopUp.isDisplayed());
        chatListScreenObject.SignOut();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        chatListScreenObject.ConfirmSignOut();
        userNameScreenObject=new UserName_Validation_Screen(driver);
        Assert.assertTrue(userNameScreenObject.Next_Step_Button.isEnabled());
        Assert.assertTrue(userNameScreenObject.Logo_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.Title_Of_UserName_Screen.isDisplayed());
        Assert.assertTrue(userNameScreenObject.UserName_Text_Box.isDisplayed());

    }
}
