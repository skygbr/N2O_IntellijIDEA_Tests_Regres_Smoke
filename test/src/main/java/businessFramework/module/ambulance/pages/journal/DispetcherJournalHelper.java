package businessFramework.module.ambulance.pages.journal;

import businessFramework.module.Values;
import businessFramework.module.ambulance.modal.CreateCallCardModal;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Container;
import net.framework.autotesting.meta.Page;
import net.framework.autotesting.meta.components.Button;

/**
 * Получение элементов на странице "Журнал диспетчера"
 */

public class DispetcherJournalHelper extends Page implements Values
{
    public DispetcherJournalHelper(ApplicationManager app)
    {
        super(app);
    }

    /**
     * Возвращает контейнер "Информация о вызове"
     * @return контейнер "Информация о вызове"
     */
    public Container getCallInformationContainer()
    {
        return getContainer("top");
    }

    /**
     * Возвращает контейнер "Журнал вызовов"
     * @return контейнер "Журнал вызовов"
     */
    public Container getCallsJournalContainer()
    {
        return getContainer("journ");
    }

    /**
     * Возвращает кнопку "Создать"
     * @return кнопка "Создать"
     */
    public Button getCreateButton()
    {
        return getCallsJournalContainer().getButton(CREATE_BUTTON);
    }

    /**
     * Возвращает модальное окно "Создать карту вызова диспетчера", т.к. оно вызывается с текушего окна
     * @return модальное окно "Создать карту вызова диспетчера"
     */
    public CreateCallCardModal getCreateCallCardModal()
    {
        return new CreateCallCardModal(app);
    }

}
