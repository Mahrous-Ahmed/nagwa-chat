package Receive_Messages_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Emojis_Text extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;
    String  Emojis = "\uD83D\uDE22\uD83D\uDE24\uD83D\uDE2D\uD83D\uDE28\uD83D\uDE3B\uD83D\uDE4F\uD83D\uDE4B\uD83C\uDFFF\uD83D\uDE4B\uD83C\uDFFF";
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive Emojis text")
    public void receive_Emojis_Text() {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.messages.size()-1;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(),Emojis);

    }
}
