package businessFramework.module.stocks.pages.mainInformation;

import businessFramework.entities.stocks.MainInformationData;
import businessFramework.module.Values;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Button;


/**
 * Created by aisaev on 03.08.2015.
 */
public class MainInformationContainer extends MainInformationHelper implements Values
{
    public MainInformationContainer(ApplicationManager app)
    {
        super(app);
    }


    public void compareMainInformation(MainInformationData mainInformationData) {
       getCode().assertValue(mainInformationData.getCode());
       getFullName().assertValue(mainInformationData.getFullName());
       getShortName().assertValue(mainInformationData.getShortName());
       getRegDate().assertValue(mainInformationData.getRegDate());
    }


    public void fill(MainInformationData mainInformationData) {
        getCode().setValue(mainInformationData.getCode());
        getFullName().setValue(mainInformationData.getFullName());
        getShortName().setValue(mainInformationData.getShortName());
        getRegDate().setValue(mainInformationData.getRegDate());
    }

    public void clickConfirmButton() {
        Button confirm = getConfirmButton();
        confirm.assertIsEnabled();
        confirm.click();
    }


}
