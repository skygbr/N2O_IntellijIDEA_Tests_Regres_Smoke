package businessFramework.module.vaccination;

import businessFramework.module.vaccination.pages.dictionary.DenyReasonsPage;
import businessFramework.module.vaccination.pages.dictionary.DosesPage;
import businessFramework.module.vaccination.pages.dictionary.VaccineProducersPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

/**
 * Created by bulat.garipov on 27.12.2015.
 */
public class DictionaryManager {

    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    //Открытие модуля Вакцинопрофилактики
    public void openVaccinationModule() {
        app.getNavigationHelper().openPageWithModule("modules.vaccine");
    }

    //Открытие страницы Производители вакцин
    public void openVaccineProducerDictionaryPage() {
        page.getHeader().openSpaceAndPage("Справочники", "vaccine.vaccine_producers");
    }

    //Получение страницы Производители вакцин
    public VaccineProducersPage getVaccineProducerPage() {
        return new VaccineProducersPage(app);
    }

    //Открытие страницы "Причины медицинских отводов"
    public void openDenyReasonDictionaryPage() {
        page.getHeader().openSpaceAndPage("Справочники", "vaccine.deny_reason");
    }

    //Получение страницы "Причины медицинских отводов"
    public DenyReasonsPage getDenyReasonPage() {
        return new DenyReasonsPage(app);
    }

    //Открытия страницы "Дозировки"
    public void  openDoseDictionaryPage() {
        page.getHeader().openSpaceAndPage("Справочники", "vaccine.doses");
    }

    //Получение страницы "Дозировки"
    public DosesPage getDosePage() {
        return new DosesPage(app);
    }
}
