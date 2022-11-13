package Send_Messages_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;


import java.util.concurrent.TimeUnit;

public class Send_Numbers extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;
    String Numbers= ReadProperties.userDate.getProperty("Numbers");

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user send numbers")
    @Parameters({"Timezone"})
    public void send_numbers(String Timezone)  {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.typingText(Numbers);
        chatGroupScreenObject.sendMessage();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(chatGroupScreenObject.TextOfLastMessage(),Numbers);
        Assert.assertEquals(chatGroupScreenObject.ServerCurrentTimeZone(Timezone),chatGroupScreenObject.TimeOfTheLastTextMessage());

    }
}
