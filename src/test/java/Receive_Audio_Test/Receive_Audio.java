package Receive_Audio_Test;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Audio extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive audio")
    public void receiveAudio()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.AudioPlayer.size()-1;
        Assert.assertTrue(chatGroupScreenObject.AudioPlayer.get(indexOfLastElement).isDisplayed());
    }
}
