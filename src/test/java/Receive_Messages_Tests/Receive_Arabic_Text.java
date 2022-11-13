package Receive_Messages_Tests;

import Test_Bases.Test_Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Receive_Arabic_Text extends Test_Base {


    Chat_Group_Screen chatGroupScreenObject;
    String ArabicMessage="السلام عليكم";

    @Test()
    public void receive_Arabic_Text()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        int indexOfLastElement=chatGroupScreenObject.messages.size()-4;
        System.out.println(chatGroupScreenObject.messages.get(indexOfLastElement).getText());
        Assert.assertEquals(chatGroupScreenObject.messages.get(indexOfLastElement).getText(),ArabicMessage);

    }
}
