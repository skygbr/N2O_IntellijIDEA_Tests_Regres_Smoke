package businessFramework.module.vaccination.pages.dictionary;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.Classifier;
import net.framework.autotesting.meta.components.InputText;

/**
 * Created by bulat.garipov on 27.12.2015.
 * Фильтры на странице "Дозировки"
 */
public class DosesFilter extends DosesHelper{

    public DosesFilter(ApplicationManager app) {
        super(app);
    }

    // Фильтр по полю "Доза" контейнера "Дозировки"
    public InputText getCount() {
        return this.getDoseContainer().getFilter().getInputText("count");
    }

    // Фильтр по полю "Единица измерения" контейнера "Дозировки"
    public Classifier getDoseType() {
        return this.getDoseContainer().getFilter().getClassifier("doseType");
    }

    // Фильтр по полю "Код" контейнера "Дозировки"
    public InputText getDoseCode() {
        return this.getDoseContainer().getFilter().getInputText("code");
    }

    // Фильтр по полю "Код" контейнера "Единицы измерения"
    public InputText getDoseTypeCode() {
        return this.getDoseTypeContainer().getFilter().getInputText("code");
    }

    // Фильтр по полю "Единица измерения" контейнера "Единицы измерения"
    public InputText getDoseTypeLabel() {
        return this.getDoseTypeContainer().getFilter().getInputText("label");
    }
}
