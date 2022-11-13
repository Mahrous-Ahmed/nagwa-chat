package Receive_Audio_Test;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;
import screens.Chat_List_Screen;

import java.util.concurrent.TimeUnit;

public class Playback_Audio_received extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;
    Chat_List_Screen chatListScreenObject;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("user can play the received audio")
    public void playAudio()  {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.playAudio();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chatGroupScreenObject.backToChatList();
        chatListScreenObject=new Chat_List_Screen(driver);
        Assert.assertTrue(chatListScreenObject.profileIcon.isDisplayed());
    }
}
