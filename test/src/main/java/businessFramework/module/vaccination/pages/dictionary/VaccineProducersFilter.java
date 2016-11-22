package businessFramework.module.vaccination.pages.dictionary;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Фильтры на странице "Производители вакцин"
 */
public class VaccineProducersFilter extends VaccineProducersHelper {

    public VaccineProducersFilter(ApplicationManager app) {
        super(app);
    }

    // Фильтр по полю "Страна"
    public Classifier getCountry() {
        return this.getVacineProducerContainer().getFilter().getClassifier("country");
    }

    // Фильтр по полю "Наименование"
    public InputText getLabel() {
        return this.getVacineProducerContainer().getFilter().getInputText("label");
    }

    // Фильтр по полю "Полное наименование"
    public InputText getFullName() {
        return this.getVacineProducerContainer().getFilter().getInputText("full_name");
    }
}
