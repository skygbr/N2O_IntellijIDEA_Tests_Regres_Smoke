package businessFramework.module.stomatology.modals.stomInspection;

/**
 * Created by RTlabs on 02.08.2016.
 */
public class StomInspectionModal extends StomInspectionHelper{

    /**
     * нажатие кнопки добавления осмотра
     */
    public void createStomInspection(){
        getButtonCreateInspection().click();
    }
    /**
     * нажатие кнопки редактирования осмотра
     */
    public void editStomInspection(){
        getTable().chooseRowInTable(0);
        getButtonEditInspection().click();
    }
    /**
     * удаляет все осмотры
     */
    public void deleteStomInspection(){
        while (getTable().getCountRowsInTable(true)>0) {
            getTable().chooseRowInTable(0);
            getButtonDeleteInspection().click();
            page.getDialog().clickYes();
        }
    }
}
