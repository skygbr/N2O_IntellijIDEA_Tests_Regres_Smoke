package businessFramework.module.gibddMedicalExamination.modals.CloseCard;


import net.framework.autotesting.meta.components.Button;

public class CloseCardModal {
    private CloseCardHelper closeCardHelper;

    public CloseCardModal() {
        closeCardHelper = new CloseCardHelper();
    }

    public CloseCardModal(String locator) {
        closeCardHelper = new CloseCardHelper(locator);
    }

    //
    public void clickConfirmButton() {
        Button confirm = closeCardHelper.getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }

    public void assertAndAccept() {
        closeCardHelper.getReason().assertValue_equals("Выдана, годен");
        clickConfirmButton();
    }
}