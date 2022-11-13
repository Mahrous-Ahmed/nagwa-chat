package Receive_photo_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Single_Photo extends Test_Base {

    Chat_Group_Screen chatGroupScreenObject;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user receive photo")
    public void receivePhoto() {
        chatGroupScreenObject = new Chat_Group_Screen(driver);
        int indexOfLastElement = chatGroupScreenObject.photos.size()-1;
        Assert.assertTrue(chatGroupScreenObject.photos.get(indexOfLastElement).isDisplayed());
    }
}
