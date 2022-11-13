package Delete_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;
import screens.Chat_List_Screen;
import screens.Delete_Screen;

import java.util.concurrent.TimeUnit;

public class Delete_Text extends Test_Base {



    Delete_Screen deleteScreenObject;

    Chat_Group_Screen chatGroupScreenObject;
    String DeletedMessageText="this message has been deleted";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("User delete it Own Message")
    public void User_Delete_Text_Message() {

        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.chooseMessageToDelete();
        deleteScreenObject=new Delete_Screen(driver);
        deleteScreenObject.deleteMessage();
        deleteScreenObject.ConfirmDelete();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(chatGroupScreenObject.TextOfLastMessage(), DeletedMessageText);


    }



}
