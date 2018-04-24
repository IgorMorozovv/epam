package mail.using;

import mail.tests.BasicTestClass;

//TODO: Классы не называют действиями. Это может быть DraftCreator или DraftService например.
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

    // TODO: из названия любого методы мы должны понимать что этот метод делает.
    // Пожалуйста, конкретизируй.
    public void save() {
	basicTestClass.getWriteLetterPage().save();
    }

}
