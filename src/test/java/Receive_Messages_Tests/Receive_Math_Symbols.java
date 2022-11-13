package Receive_Messages_Tests;

import Data.ReadProperties;
import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Math_Symbols extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;
    String MathSymbols=ReadProperties.userDate.getProperty("MathSymbols");


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive math symbols")
    public void receive_Math_Symbols()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.messages.size()-2;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(),MathSymbols);

    }






}
