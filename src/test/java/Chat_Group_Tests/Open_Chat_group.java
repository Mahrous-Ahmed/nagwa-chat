package Chat_Group_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;
import screens.Chat_List_Screen;

public class Open_Chat_group extends Test_Base {
    Chat_List_Screen chatListScreenObject;
    Chat_Group_Screen chatGroupScreenObject;

    String chatListScreenTitle= ReadProperties.userDate.getProperty("ChatListScreenTitle");
    String ChatGroupName=ReadProperties.userDate.getProperty("ChatGroupName");

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to open chat group")
    public void open_chat_group()  {
        chatListScreenObject =new Chat_List_Screen(driver);
        Assert.assertTrue(chatListScreenObject.profileIcon.isDisplayed());
        Assert.assertEquals(chatListScreenObject.ScreenTitle.getText(),chatListScreenTitle);
        Assert.assertFalse(chatListScreenObject.chatList.isEmpty());
        chatListScreenObject.OpenWantedChatGroup();
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        Assert.assertTrue(chatGroupScreenObject.backKey.isDisplayed());
        Assert.assertEquals(chatGroupScreenObject.chatGroupTitle.getText(),ChatGroupName);
        Assert.assertTrue(chatGroupScreenObject.inputMessageTextBox.isDisplayed());
        Assert.assertTrue(chatGroupScreenObject.recordAudioButton.isDisplayed()&&chatGroupScreenObject.recordAudioButton.isEnabled());
        Assert.assertTrue(chatGroupScreenObject.photoButton.isDisplayed()&&chatGroupScreenObject.photoButton.isEnabled());






    }
}
