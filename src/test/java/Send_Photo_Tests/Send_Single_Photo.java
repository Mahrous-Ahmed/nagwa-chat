package Send_Photo_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;
import screens.Device_Files;
import screens.Pre_Send_Preview_Screen;



public class Send_Single_Photo extends Test_Base {
    Chat_Group_Screen chatScreenObject;
    Device_Files deviceFileScreenObject;
    Pre_Send_Preview_Screen preSendPreview_Screen;


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("user send photo")
    @Parameters({"Timezone"})
    public void SendPhoto(String Timezone) throws InterruptedException {
        chatScreenObject=new Chat_Group_Screen(driver);
        chatScreenObject.photoPermission();
        chatScreenObject.OpenDeviceGallery();
        deviceFileScreenObject=new Device_Files(driver);
       // Assert.assertTrue(deviceFileScreenObject.NativePhotosApp.isDisplayed());
        deviceFileScreenObject.selectPhoto();
        preSendPreview_Screen=new Pre_Send_Preview_Screen(driver);
        Assert.assertTrue(preSendPreview_Screen.currentImage.isDisplayed());
        Assert.assertTrue(preSendPreview_Screen.closeIcon.isEnabled());
        Assert.assertTrue(preSendPreview_Screen.trashIcon.isEnabled());
        Assert.assertTrue(preSendPreview_Screen.AddPhotoButton.isEnabled());
        Assert.assertTrue(preSendPreview_Screen.sendButton.isEnabled());
        preSendPreview_Screen.send_Photo();
        Thread.sleep(5000);
        Assert.assertFalse(chatScreenObject.photos.isEmpty());
        Assert.assertEquals(chatScreenObject.ServerCurrentTimeZone(Timezone),chatScreenObject.TimeOfTheLastTextMessage());



    }
}
