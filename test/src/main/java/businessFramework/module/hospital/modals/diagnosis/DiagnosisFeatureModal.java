package businessFramework.module.hospital.modals.diagnosis;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;

public class DiagnosisFeatureModal implements Values
{
    private Page page = Page.getInstance();
    private DiagnosisHelper diagnosisHelper;

    public DiagnosisFeatureModal()
    {
        diagnosisHelper = new DiagnosisHelper();
    }

    private Container getValueContainer(){
        return page.getModal().getContainer("value");
    }

    //Выбор Характеристики
    public String selectFeature()
    {
        page.getModal().assertModalHeader_contains("Характеристика");
        getValueContainer().getTable().chooseRowInTable(0);
        String chosenValue = getValueContainer().getTable().getRowColumnIntersectionValue(0, "Наименование", true);
        page.getModal().getButton(CONFIRM_BUTTON).click();
        return chosenValue.trim();
    }
}
