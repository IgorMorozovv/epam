package mail.using;

import mail.tests.BasicTestClass;

public class CreateDraft {
    BasicTestClass basicTestClass;

    public CreateDraft(BasicTestClass basicTestClass) {
	this.basicTestClass = basicTestClass;
    }

    public void fillFields(String receiver, String subject, String message) {

	basicTestClass.getCommonButtons().clickWriteMessageButton();

	basicTestClass.getWriteLetterPage().fillToField(receiver);

	basicTestClass.getWriteLetterPage().clickByMessageField();

	basicTestClass.getWriteLetterPage().fillSubjectField(subject);

	basicTestClass.getWriteLetterPage().fillMessageField(message);

    }

    public void save() {
	basicTestClass.getWriteLetterPage().save();
    }

}
