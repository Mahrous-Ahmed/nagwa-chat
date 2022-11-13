package Send_Audio_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;


import java.util.concurrent.TimeUnit;

public class Send_Audio extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to send audio")
    @Parameters({"Timezone"})
    public void send_Audio(String Timezone) {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.audioPermission();
        chatGroupScreenObject.recordAudio();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Assert.assertFalse(chatGroupScreenObject.AudioPlayer.isEmpty());
        Assert.assertEquals(chatGroupScreenObject.ServerCurrentTimeZone(Timezone),chatGroupScreenObject.TimeOfTheLastTextMessage());
    }
}
