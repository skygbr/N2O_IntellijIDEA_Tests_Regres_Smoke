package businessFramework.module.clinic.modals.modifyHomeReception;

/**
 * Created by asamoilov on 20.08.2015.
 */
public class ModifyHomeReceptionModal {
    private ModifyHomeReceptionHelper modifyHomeReceptionHelper;
    public ModifyHomeReceptionModal(){
        modifyHomeReceptionHelper = new ModifyHomeReceptionHelper();
    }
    public void assertCancelReason(){
        modifyHomeReceptionHelper.getCancelReason().assertValue_contains("Отказ пациента");

    }
}
