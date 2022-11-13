package Receive_Messages_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_English_Text extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;
    String EnglishMessage = ReadProperties.userDate.getProperty("EnglishText");
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive English text")
    public void receive_English_Text() {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.messages.size()-5;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(),EnglishMessage);
    }
}
