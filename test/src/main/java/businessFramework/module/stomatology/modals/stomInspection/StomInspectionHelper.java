package businessFramework.module.stomatology.modals.stomInspection;

import businessFramework.module.Values;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.Table;
import net.framework.autotesting.meta.components.Button;

/**
 * Created by RTlabs on 02.08.2016.
 */
public class StomInspectionHelper implements Values{
    public Page page = Page.getInstance();

    public Container getContainerInspection(){
        return page.getModal().getContainer("main");
    }
    public Table getTable() {
        return getContainerInspection().getTable();
    }
    public Button getButtonCreateInspection(){
        return getContainerInspection().getButton("createInspection");
    }
    public Button getButtonEditInspection(){
        return getContainerInspection().getButton("editInspection");
    }
    public Button getButtonDeleteInspection(){
        return getContainerInspection().getButton("delete");
    }
}
