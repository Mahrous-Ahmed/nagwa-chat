package Receive_Messages_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Numbers_Text extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;

    String Numbers= ReadProperties.userDate.getProperty("Numbers");

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive Numbers ")
    public void receive_Numbers_Text()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.messages.size()-3;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());

        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(),Numbers);

    }
}
