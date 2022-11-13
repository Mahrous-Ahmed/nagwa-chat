package Send_Messages_Tests;


import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

import java.util.concurrent.TimeUnit;

public class Send_Emojis extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;
    String Emojis = "\uD83D\uDE22\uD83D\uDE24\uD83D\uDE2D\uD83D\uDE28\uD83D\uDE3B\uD83D\uDE4F\uD83D\uDE4B\uD83C\uDFFF\uD83D\uDE4B\uD83C\uDFFF";
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user send Emojis text")
    @Parameters({"Timezone"})
    public void send_Emojis_text(String Timezone)  {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        chatGroupScreenObject.typingText(Emojis);
        chatGroupScreenObject.sendMessage();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(chatGroupScreenObject.TextOfLastMessage(),Emojis);
        Assert.assertEquals(chatGroupScreenObject.ServerCurrentTimeZone(Timezone),chatGroupScreenObject.TimeOfTheLastTextMessage());

    }



    @Test(priority = 1)
    @Severity(SeverityLevel.MINOR)
    @Description("back to chat list")
    public void chatList()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.backToChatList();
    }

}
