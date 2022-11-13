package Delete_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Deleted_Text extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;
    String DeletedMessageText="this message has been deleted";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Educator receive delete message text from student")
    public void receive_Emojis_Text()
    {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        int indexOfLastElement = chatGroupScreenObject.messages.size() - 1;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(), DeletedMessageText);
    }
}
