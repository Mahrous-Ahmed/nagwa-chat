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

public class Send_MathSymbols extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;
    String MathSymbols= ReadProperties.userDate.getProperty("MathSymbols");

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user send math symbols")
    @Parameters({"Timezone"})
    public void send_Math_Symbols(String Timezone)  {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.typingText(MathSymbols);
        chatGroupScreenObject.sendMessage();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertEquals(chatGroupScreenObject.TextOfLastMessage(),MathSymbols);
        Assert.assertEquals(chatGroupScreenObject.ServerCurrentTimeZone(Timezone),chatGroupScreenObject.TimeOfTheLastTextMessage());


    }



}
