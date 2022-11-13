package Delete_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class CheckDeleteText extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;
    String DeletedMessageText="this message has been deleted";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("check delete message")
    public void check_Delete_messages() {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        int indexOfLastElement = chatGroupScreenObject.messages.size() - 1;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(), DeletedMessageText);
        int indexDeletedPhotoElement = chatGroupScreenObject.messages.size() - 2;
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexDeletedPhotoElement).getText(), DeletedMessageText);


    }
}
