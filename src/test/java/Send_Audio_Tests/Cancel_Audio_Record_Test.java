package Send_Audio_Tests;

import Test_Bases.Test_Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Chat_Group_Screen;

public class Cancel_Audio_Record_Test extends Test_Base {
    Chat_Group_Screen chatGroupScreenObject;

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("try to cancel audio Recording")
    public void cancel_recording()
    {
        chatGroupScreenObject=new Chat_Group_Screen(driver);
        int TotalNumberOfAudiosBeforeCancel=chatGroupScreenObject.AudioPlayer.size();
        chatGroupScreenObject.cancelRecord();
        int TotalNumberOfAudiosAfterCancel=chatGroupScreenObject.AudioPlayer.size();
        Assert.assertEquals(TotalNumberOfAudiosAfterCancel,TotalNumberOfAudiosBeforeCancel);
    }
}
