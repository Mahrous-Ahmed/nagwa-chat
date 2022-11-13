package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Alert;



import java.util.List;

public class Chat_List_Screen extends Screen_Base {
    public Chat_List_Screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    @AndroidFindBy(id = "ivUser")
    @iOSXCUITFindBy(accessibility = "invalidName")
    public MobileElement profileIcon;

    @AndroidFindBy(id = "com.nagwa.chat:id/textView")
    @iOSXCUITFindBy()
    public MobileElement ScreenTitle;


    /*a)chat group name put it inside @text attribute
      b)scroll till find this chat group

      why i put it as a list no an element ?
      because if this element doesn't appear in the top 9 element in the list no such element exception happens
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='01my new physics']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='01my new physics']")
    public List<MobileElement> chatGroupName;





    @AndroidFindBy(id = "chatListLayout")
    @iOSXCUITFindBy()
    public List<MobileElement> chatList;


    @AndroidFindBy(id = "tvLanguageName")
    @iOSXCUITFindBy()
    public MobileElement signOutBtnInSignOutPopUp;

    @AndroidFindBy(id = "tvActionTitle")
    @iOSXCUITFindBy()
    public MobileElement studentNameInSignOutPopUp;

    @AndroidFindBy(id = "tvCancel")
    @iOSXCUITFindBy()
    public MobileElement cancelBTNInSignOutPopUP;


    public List<MobileElement> getChatGroupName() {
        return chatGroupName;
    }

    public void OpenWantedChatGroup()
    {
        // == zero means null 
        while (getChatGroupName().size()==0)
        {
            scroll_bottom();
        }
        if (getChatGroupName().size()>0)
        {
            getChatGroupName().get(0).click();
        }
    }
    public void OpenProfileMenu()

    {
        click(profileIcon);
    }

    public void SignOut()

    {
        click(signOutBtnInSignOutPopUp);

    }

    public void ConfirmSignOut()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }




}
