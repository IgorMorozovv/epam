package mail.using;

import org.openqa.selenium.WebDriver;

import mail.tests.BasicTestClass;

public class Drafts {

    WebDriver driver;
    BasicTestClass basicTestClass;

    public Drafts(BasicTestClass basicTestClass) {
	this.basicTestClass = basicTestClass;
    }

    public void deleteDrafts() {
	basicTestClass.getLinksToMainPages().toDraftLinkClick();
	basicTestClass.getDraftPage().waitTitle();

	basicTestClass.getDraftPage().selectAllDrafts();
	basicTestClass.getCommonButtons().clickDeleteButton();
    }

}
