package Receive_photo_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;
import screens.Photo_Gallery;

public class View_Last_Photo extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;
    Photo_Gallery photoGalleryScreenObject;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("User Can view the sent photo")
    public void ViewPhotoInPhotoGallery()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        chatGroupScreenObject.openSentPhoto();
        photoGalleryScreenObject=new Photo_Gallery(driver);
        Assert.assertTrue(photoGalleryScreenObject.photoInGallery.isDisplayed());
        Assert.assertTrue(photoGalleryScreenObject.closeButton.isEnabled());
        Assert.assertTrue(photoGalleryScreenObject.shadow.isDisplayed());
        photoGalleryScreenObject.closeGallery();
        chatGroupScreenObject.backToChatList();

    }

}

