package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;



import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public class Chat_Group_Screen extends Screen_Base{
    public Chat_Group_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    TouchAction action;

    @AndroidFindBy(id = "ivBackButton")
    @iOSXCUITFindBy()
    public MobileElement backKey;

    @AndroidFindBy(id = "tvChatGroupTitle")
    @iOSXCUITFindBy()
    public MobileElement chatGroupTitle;


    @AndroidFindBy(id = "etMessageInput")
    @iOSXCUITFindBy()
    public MobileElement inputMessageTextBox;

    @AndroidFindBy(id = "ivSendMessageButton")
    @iOSXCUITFindBy()
    public MobileElement sendMessageBTN;

    @AndroidFindBy(id = "ivSendVoiceButton")
    @iOSXCUITFindBy()
    public MobileElement recordAudioButton;



    @AndroidFindBy(id = "com.nagwa.chat:id/ivSendPhotoButton")
    @iOSXCUITFindBy()
    public MobileElement photoButton;

    @AndroidFindBy(id = "tvMessageText")
    @iOSXCUITFindBy()
    public List<MobileElement> messages;

    @AndroidFindBy(id = "com.nagwa.chat:id/tvMessageTime")
    @iOSXCUITFindBy()
    public  List<MobileElement> messageTime;

    @AndroidFindBy(id = "com.nagwa.chat:id/ivPhotoMessage")
    @iOSXCUITFindBy()
    public  List<MobileElement> photos;



    @AndroidFindBy(id = "audio_play")
    @iOSXCUITFindBy()
    public List<MobileElement> AudioPlayer;





    public void playAudio()  {


        int lastVoice = AudioPlayer.size();
        click(AudioPlayer.get(lastVoice-1));

    }



    public void sendMessage()
    {
        click(sendMessageBTN);
    }
    public void typingText(String value)
    {

        click(inputMessageTextBox);
        clear(inputMessageTextBox);
        sendText(inputMessageTextBox,value);
    }

    public void audioPermission()
    {
        click(recordAudioButton);
        driver.switchTo().alert().accept();
    }



    public void recordAudio()
    {
        //click(recordAudioButton);
        //driver.switchTo().alert().accept();
        action =new TouchAction<>(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(recordAudioButton)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                .release()
                .perform();
    }

    public void cancelRecord()
    {
        action =new TouchAction<>(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(recordAudioButton)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(8)))
                .moveTo(PointOption.point(540,848))
                .release()
                .perform();
    }



    public void backToChatList()
    {
        click(backKey);
    }

    public void photoPermission()
    {
        click(photoButton);
        driver.switchTo().alert().accept();
    }


    public void OpenDeviceGallery()  {
        //click(photoButton);
        //driver.switchTo().alert().accept();
        click(photoButton);
    }

    public void openSentPhoto()
    {
        int lastPhoto=photos.size();
        click(photos.get(lastPhoto-1));
    }


    public String ServerCurrentTimeZone(String timezone)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
        LocalDateTime now = LocalDateTime.now(ZoneId.of(timezone));
        return dtf.format(now).toUpperCase(Locale.ROOT);
    }

    public String TimeOfTheLastTextMessage()
    {
        int indexOfTextMessage=messageTime.size()-1;
        return messageTime.get(indexOfTextMessage).getText();
    }
    public String TextOfLastMessage()
    {
        int indexOfTextMessage=messages.size()-1;
        return messages.get(indexOfTextMessage).getText();
    }

    public void chooseMessageToDelete()
    {
        int indexOfTextMessage=messages.size()-1;
        action =new TouchAction<>(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(messages.get(indexOfTextMessage)))).perform().release();
    }
    public void chosePhotoToDelete()
    {
        int indexOfPhotoMessage=photos.size()-1;
        action =new TouchAction<>(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(photos.get(indexOfPhotoMessage)))).perform().release();
    }
    public void chooseAudioToDelete()
    {
        int indexOfAudioMessage=messageTime.size()-2;
        action =new TouchAction<>(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(messageTime.get(indexOfAudioMessage)))).perform().release();

    }



}
