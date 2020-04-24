package extend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
   // @Test
    //@ParameterizedTest
    //@CsvSource({"smartest@gmail.com",   "Qazxsw12"})
   // public void happyPathLoginTest(){
    //    LoginPage.go("https://www.youtube.com/");
        //LoginPage.SignIn("smartest.local@gmail.com","Qazxsw12!");
   // }
    @Test
    public void dropDownBoxTest() throws InterruptedException{
        //YoutubeList.selectYoutubeOptions(YoutubeList.subMenueMusic);
        JetPage.PageBuilder.newInstance().go("https://www.redtag.ca/");
        JetPage.selectJetOptions(JetPage.menuSelectorFrom, JetPage.subMenuePune);
        JetPage.selectJetOptions(JetPage.menuSelectorFrom, JetPage.subMenue);
        //Thread.sleep(60000);

    }
    @Test
    public void checkBoxTest() {
        JetPage.PageBuilder.newInstance().selectWebElement(JetPage.friendsAndFamily);
        Assertions.assertTrue(JetPage.isCheckBoxSelected(JetPage.friendsAndFamily));
    }
    @Test
    public void radioButtonCount(){
        System.out.println("COUNT " + JetPage.getRadioButtonsCount(JetPage.radioButtons));
        Assertions.assertTrue(JetPage.getRadioButtonsCount(JetPage.radioButtons).equals((long)2));
    }
}
