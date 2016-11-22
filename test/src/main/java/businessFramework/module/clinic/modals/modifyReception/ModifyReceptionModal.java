package businessFramework.module.clinic.modals.modifyReception;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ModifyReceptionModal {
    private ModifyReceptionHelper modifyReceptionHelper;
    public ModifyReceptionModal(){
        modifyReceptionHelper = new ModifyReceptionHelper();
    }
    public void assertCancelReason(){
        modifyReceptionHelper.getCancelReason().assertValue_contains("Отказ пациента");
    }
    public void setValue(){
        modifyReceptionHelper.getCancelReason().setValue("Отказ пациента");
    }
    public void clickConfirm(){
        modifyReceptionHelper.getConfirmButton().click();
    }
}
