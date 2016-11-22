package businessFramework.module.stomatology.modals.stomMedicalCard;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 20.07.2016.
 */
public class StomMedicalCardHelper implements Values {
    public Page page = Page.getInstance();

    public Container getContainerMedicalCard(){
        return page.getModal().getContainer("cardPlace");
    }
    public Table getTable() {
        return getContainerMedicalCard().getTable();
    }
    public Button getButtonCreateMedicalCard(){
        return getContainerMedicalCard().getButton("addCardPlace");
    }
    public Button getButtonDeleteMedicalCard(){
        return getContainerMedicalCard().getButton("deleteCardPlace");
    }
}
